package server.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import server.dto.LoginDTO;
import server.dto.RegisterDTO;
import server.dto.UserLoginDTO;
import server.dto.UserRegisterDTO;

public interface AuthService {
	
	public UserLoginDTO userLogin(LoginDTO dto);
	public UserRegisterDTO register(RegisterDTO dto);
	public void sendVerificationEmail(UserRegisterDTO dto) throws UnsupportedEncodingException, MessagingException;
	public boolean verify(String verifiticationCode);
	public void updateUserStatus(int id);
	public boolean checkIfUserExist(String email);
}
