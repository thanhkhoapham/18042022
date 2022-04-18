package server.service;

import java.util.List;

import server.dto.UserDTO;
import server.dto.UserInfoDTO;
import server.entity.NguoiDung;


public interface NguoiDungService {
	public NguoiDung getUserById(int id);
	public UserInfoDTO getUserInfoById(int id);
	public UserInfoDTO getUserInfo(NguoiDung nguoiDung);
	public List<UserDTO> getListUser();
}
