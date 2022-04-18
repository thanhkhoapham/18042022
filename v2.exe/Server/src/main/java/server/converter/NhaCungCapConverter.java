package server.converter;

import org.springframework.stereotype.Component;

import server.dto.NhaCungCapDTO;
import server.entity.NhaCungCap;

@Component
public class NhaCungCapConverter {

//	@Autowired
//	private NhaCungCapRepository repository;

	public NhaCungCap toEntity(NhaCungCapDTO dto) {
		NhaCungCap ncc = null;
		if (dto != null) {
			ncc = new NhaCungCap();
			ncc.setId(dto.getId());
			ncc.setTenNhaCungCap(dto.getTenNhaCungCap());
			ncc.setDiaChi(dto.getDiaChi());
			ncc.setSoDienThoai(dto.getSoDienThoai());
			ncc.setEnable(dto.isEnable());
		}
		return ncc;
	}

	public NhaCungCapDTO toDTO(NhaCungCap ncc) {
		NhaCungCapDTO dto = null;
		if (ncc != null) {
			dto = new NhaCungCapDTO();
			dto.setId(ncc.getId());
			dto.setTenNhaCungCap(ncc.getTenNhaCungCap());
			dto.setDiaChi(ncc.getDiaChi());
			dto.setSoDienThoai(ncc.getSoDienThoai());
			dto.setEnable(ncc.isEnable());
		}
		return dto;
	}
}
