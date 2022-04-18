package server.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import server.dto.LoginDTO;
import server.dto.RegisterDTO;
import server.dto.UserLoginDTO;
import server.dto.UserRegisterDTO;
import server.entity.NguoiDung;
import server.entity.Role;
import server.repository.NguoiDungRepository;
import server.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.utility.RandomString;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private NguoiDungRepository uRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public AuthServiceImpl(NguoiDungRepository uRepository, AuthenticationManager authenticationManager) {
		this.uRepository = uRepository;
		this.authenticationManager = authenticationManager;
	}

	@Override
	public UserRegisterDTO register(RegisterDTO dto) throws DataIntegrityViolationException{
		String hashedPassword = BCrypt.hashpw(dto.getMatKhau(), BCrypt.gensalt());
		
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setEmail(dto.getEmail());
		nguoiDung.setMatKhau(hashedPassword);
		nguoiDung.setRole(new Role(2));
		nguoiDung.setEnable(false);
		nguoiDung.setTenNguoiDung(dto.getTenNguoiDung());
		nguoiDung.setSoDienThoai(dto.getSoDienThoai());
		nguoiDung.setDiaChi(dto.getDiaChi());
		
		String randomCode = RandomString.make(64);
		nguoiDung.setVerificationCode(randomCode);
		
		uRepository.save(nguoiDung);
		return new UserRegisterDTO(nguoiDung.getId(), nguoiDung.getEmail(), nguoiDung.getVerificationCode());
	}

	@Override
	public void sendVerificationEmail(UserRegisterDTO dto) throws UnsupportedEncodingException, MessagingException {
		String subject = "[...] Xác minh tài khoản";
		String senderName = "Shop";
		String mailContent = "<p>Chào " + dto.getEmail().split("@")[0] + ",</p>";
		mailContent += "<p>Cảm ơn bạn vì đã đăng ký dịch vụ của chúng tôi. Vui lòng click vào link bên dưới để hoàn tất việc đăng ký:</p>";

		String verifyURL =  "http://localhost:7070/auth/verify?code=" + dto.getVerificationCode();

		mailContent += "<h3><a href=\""+ verifyURL + "\">VERIFY</a></h3>";
		mailContent += "<p>Cảm ơn<br>";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		helper.setFrom("giaanh7140@gmail.com", senderName);
		helper.setTo(dto.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent, true);

		mailSender.send(message);
	}

	@Override
	public boolean verify(String verifiticationCode) {
		NguoiDung user = uRepository.findByVerificationCode(verifiticationCode);
		if(user == null || user.isEnable()) {
			return false;
		} else {
			updateUserStatus(user.getId());
			return true;
		}
	}

	@Override
	public void updateUserStatus(int id) {
		NguoiDung nguoiDung = uRepository.findById(id).orElse(null);
		nguoiDung.setEnable(true);
		nguoiDung.setVerificationCode(null);

		uRepository.save(nguoiDung);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return uRepository.findUserByEmail(email)!= null ? true:false;
	}

	@Override
	public UserLoginDTO userLogin(LoginDTO loginDTO) {
		authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getMatKhau()));

		// Create token
		Date now = new Date();
		String token = Jwts.builder().setSubject(loginDTO.getEmail()).setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + 86400000L)).signWith(SignatureAlgorithm.HS512, "ABC_EGH")
				.compact();
		
		// Get user information
		NguoiDung entity = uRepository.findUserByEmail(loginDTO.getEmail());
		// Convert entity to dto
		UserLoginDTO dto = new UserLoginDTO();
		dto.setToken(token);
		dto.setUserId(entity.getId());
		dto.setUserName(entity.getTenNguoiDung());
		dto.setEnable(entity.isEnable());
		return dto;
	}

}
