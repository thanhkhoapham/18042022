package server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.dto.UserDTO;
import server.dto.UserInfoDTO;
import server.entity.NguoiDung;
import server.repository.NguoiDungRepository;
import server.service.NguoiDungService;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository repository;

	@Override
	public NguoiDung getUserById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public UserInfoDTO getUserInfo(NguoiDung nguoiDung) {
		UserInfoDTO dto = new UserInfoDTO();
		dto.setId(nguoiDung.getId());
		dto.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		dto.setDiaChi(nguoiDung.getDiaChi());
		dto.setEmail(nguoiDung.getEmail());
		dto.setSoDienThoai(nguoiDung.getSoDienThoai());
		return dto;
	}

	@Override
	public UserInfoDTO getUserInfoById(int id) {
		NguoiDung nguoiDung = repository.findById(id).orElse(null);
		if (nguoiDung != null) {
			return getUserInfo(nguoiDung);
		}
		return null;
	}

	@Override
	public List<UserDTO> getListUser() {
		List<NguoiDung> dungs = repository.findAll();
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (NguoiDung o : dungs) {
			list.add(new UserDTO(o.getId(), o.getTenNguoiDung(), o.getDiaChi(), o.getSoDienThoai(), o.getEmail(),
					o.getMatKhau(), o.isEnable()));
		}
		return list;
	}

}
