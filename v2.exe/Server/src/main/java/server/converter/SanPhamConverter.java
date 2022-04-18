package server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import server.dto.SanPhamDTO;
import server.entity.SanPham;
import server.repository.SanPhamRepository;

@Component
public class SanPhamConverter {
	
	@Autowired
	private SanPhamRepository repository;
	
	public SanPhamDTO toDto(SanPham sanPham) {
		SanPhamDTO dto = null;
		if (sanPham != null) {
			dto = new SanPhamDTO();
			dto.setId(sanPham.getId());
			dto.setTenSanPham(sanPham.getTenSanPham());
			dto.setGia(sanPham.getGia());
			dto.setMoTa(sanPham.getMoTa());
			dto.setUrlHinhAnh(sanPham.getUrlHinhAnh());
			dto.setEnable(sanPham.isEnable());
			dto.setLoaiSanPham(repository.getProductType(sanPham.getId()));
		}
		return dto;
	}
}
