package server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.dto.CT_GioHangDTO;
import server.dto.GioHangDTO;
import server.entity.CT_DonHang;
import server.entity.DonHang;
import server.entity.SanPham;
import server.enums.OrderStatus;
import server.repository.DonHangRepository;
import server.repository.NguoiDungRepository;
import server.repository.SanPhamRepository;
import server.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService{

	@Autowired
	private DonHangRepository donHangRepository;
	
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@Override
	public void addOrder(GioHangDTO gioHangDTO) {
		DonHang donHang = new DonHang();
		
		
		Date ngayDat = new Date();
		donHang.setNgayDat(ngayDat);
		
		//Ngày giao sau ngày đặt 7 ngày
		Date ngayGiao = new Date(ngayDat.getTime() + (1000 * 60 * 60 * 24 * 7));
		donHang.setNgayGiao(ngayGiao);
		
		//Thông tin khách hàng
		donHang.setTenNguoiDung(gioHangDTO.getDonHangForm().getTenNguoiDung());
		donHang.setDiaChi(gioHangDTO.getDonHangForm().getDiaChi());
		donHang.setSoDienThoai(gioHangDTO.getDonHangForm().getSoDienThoai());
		donHang.setNguoiDung(nguoiDungRepository.findById(gioHangDTO.getDonHangForm().getNguoiDungId()).orElse(null));
		
		donHang.setPhuongThuc(gioHangDTO.getDonHangForm().getPhuongThuc());
		donHang.setTrangThai(OrderStatus.dang_giao_hang.toString());
		donHang.setPaid(gioHangDTO.getDonHangForm().isPaid());
		
		donHangRepository.saveAndFlush(donHang);
		addOrderDetails(donHang.getId(), gioHangDTO);
		
	}
	
	@Override
	public void addOrderDetails(int donHangId, GioHangDTO gioHangDTO) {
		List<CT_GioHangDTO> items = gioHangDTO.getDsCT();
		List<CT_DonHang> dsCT = new ArrayList<CT_DonHang>();
		DonHang dh = donHangRepository.findById(donHangId).orElse(null);
		for (CT_GioHangDTO ct_GioHangDTO : items) {
			CT_DonHang ct_DonHang = new CT_DonHang();
			SanPham sp = sanPhamRepository.findById(ct_GioHangDTO.getSanPham().getId()).orElse(null);
			ct_DonHang.setSanPham(sp);
			ct_DonHang.setThanhTien(ct_GioHangDTO.getThanhTien());
			ct_DonHang.setDonHang(dh);
			ct_DonHang.setSoLuong(ct_GioHangDTO.getSoLuong());
			
			dsCT.add(ct_DonHang);
		}
		dh.setDsChiTiet(dsCT);
		donHangRepository.save(dh);
		
	}

	@Override
	public void changeOrderStatus(int donHangID, String trThaiNew) {
		DonHang donHangNew = donHangRepository.findById(donHangID).orElse(null);
		donHangNew.setTrangThai(trThaiNew);
		donHangRepository.save(donHangNew);
	}

}
