package client.service;

import client.dto.LoginDTO;
import client.dto.RegisterDTO;
import client.dto.UserLoginDTO;
import client.dto.UserRegisterDTO;

public interface AuthService {
	
	public UserLoginDTO userLogin(LoginDTO dto);
	public UserRegisterDTO register(RegisterDTO dto);
	public void verify(String verifiticationCode);
}
