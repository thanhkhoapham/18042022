package client.service;

import java.util.List;

import client.dto.UserDTO;
import client.dto.UserInfoDTO;

public interface NguoiDungService {
	public UserInfoDTO getUserInfo(int id);

	public List<UserDTO> getListUser();
}
