package client.service;

import java.util.List;

import client.dto.SanPhamDTO;

public interface SanPhamService {
	public List<SanPhamDTO> getAllProduct();
	public SanPhamDTO getProductById(int id);
}
