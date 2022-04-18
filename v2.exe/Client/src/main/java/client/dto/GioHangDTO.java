package client.dto;

import java.util.ArrayList;
import java.util.List;

import client.form.DonHangForm;

public class GioHangDTO {
	
	private DonHangForm donHangForm;
	private final List<CT_GioHangDTO> dsCT = new ArrayList<CT_GioHangDTO>();

	public DonHangForm getDonHangForm() {
		return donHangForm;
	}

	public void setDonHangForm(DonHangForm donHangForm) {
		this.donHangForm = donHangForm;
	}

	public List<CT_GioHangDTO> getDsCT() {
		return dsCT;
	}
	
	private CT_GioHangDTO timSPTheoMa(int sanpham_id) {
		for (CT_GioHangDTO ctGioHang : this.dsCT) {
			if (ctGioHang.getSanPham().getId() == sanpham_id) {
				return ctGioHang;
			}
		}
		return null;
	}
	
	public void themSanPham(SanPhamDTO sanPham, int soLuong) {
		CT_GioHangDTO ctGioHang = this.timSPTheoMa(sanPham.getId());
		
		if (ctGioHang == null) {
			ctGioHang = new CT_GioHangDTO();
			ctGioHang.setSoLuong(0);
			ctGioHang.setSanPham(sanPham);
			this.dsCT.add(ctGioHang);
		}
		
		int soLuongMoi = ctGioHang.getSoLuong() + soLuong;
		if (soLuongMoi <= 0) {
			this.dsCT.remove(ctGioHang);
		}else {
			ctGioHang.setSoLuong(soLuongMoi);
		}
	}
	
	public void capNhatSanPham(int sanPham_id, int soLuong) {
		CT_GioHangDTO ctGioHang = this.timSPTheoMa(sanPham_id);
		if (ctGioHang != null) {
			if (soLuong == 0) {
				this.dsCT.remove(ctGioHang);
			}else {
				ctGioHang.setSoLuong(soLuong);
			}
		}
	}
	
	public void xoaSanPham(SanPhamDTO sanPham) {
		CT_GioHangDTO ctGioHang = this.timSPTheoMa(sanPham.getId());
		if (ctGioHang != null) {
			this.dsCT.remove(ctGioHang);
		}
	}
	
	public double tinhTongThanhTien() {
		double tongTT = 0;
		for (CT_GioHangDTO ctGioHang : this.dsCT) {
			tongTT += ctGioHang.getThanhTien();
		}
		return tongTT;
	}
	
	public void capNhatSoLuong(GioHangDTO gioHang) {
		if (gioHang != null) {
			List<CT_GioHangDTO> dsct = gioHang.getDsCT();
			for (CT_GioHangDTO ctGioHang : dsct) {
				this.capNhatSanPham(ctGioHang.getSanPham().getId(), ctGioHang.getSoLuong());
			}
		}
	}

	@Override
	public String toString() {
		return "GioHangDTO [donHangForm=" + donHangForm + ", dsCT=" + dsCT + "]";
	}

	
	
	
}
