package server.service;

import server.dto.GioHangDTO;

public interface DonHangService {
	
	public void addOrder(GioHangDTO gioHangDTO);
	public void changeOrderStatus(int donHangID, String trThaiNew);
	public void addOrderDetails(int donHangId, GioHangDTO gioHangDTO);
}
