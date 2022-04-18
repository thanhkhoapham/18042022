package server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import server.entity.NguoiDung;
import server.repository.NguoiDungRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		NguoiDung nguoiDung = nguoiDungRepository.findUserByEmail(email);
		
		if (nguoiDung == null) {
			throw new UsernameNotFoundException("Email " + email + " không tồn tại!");
		}
		
		String role = nguoiDung.getRole().getTenRole();
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		//ROLE_ADMIN, ROLE_USER
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
		grantList.add(authority);
 
        UserDetails userDetails = (UserDetails) new User(nguoiDung.getEmail(), nguoiDung.getMatKhau(), grantList);
 
        return userDetails;
	}

}
