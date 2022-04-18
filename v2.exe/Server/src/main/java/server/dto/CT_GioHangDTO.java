package server.dto;

public class CT_GioHangDTO {
	private SanPhamDTO sanPham;
	private int soLuong;
	private double thanhTien;
	
	public CT_GioHangDTO() {
	}

	public CT_GioHangDTO(SanPhamDTO sanPham, int soLuong, double thanhTien) {
		this.sanPham = sanPham;
		this.soLuong = 1;
		this.thanhTien = sanPham.getGia();
	}

	public SanPhamDTO getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPhamDTO sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		thanhTien = sanPham.getGia() * soLuong;
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "CT_GioHangDTO [sanPham=" + sanPham.getId() + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + "]";
	}
	
	
	
	
}
