package server.service;

import java.util.List;

import server.dto.LaptopDTO;
import server.dto.SanPhamDTO;

public interface SanPhamService {
	public List<SanPhamDTO> getAllProduct();
	public SanPhamDTO getProductById(int id);
	
	public void initData();
	
//	public Object getProductDetail(String type, int id);
//	public LaptopDTO getLaptopDetail(int id);
//	
//	public List<SanPhamDTO> getProductsByType(String type);
}
