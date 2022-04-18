package server.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "don_hang")
public class DonHang implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9118875345728628606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date ngayDat;
	private Date ngayGiao;
	private String trangThai;
	private String phuongThuc;
	private boolean isPaid;
	
	//Thông tin người đặt hàng
	@Column(columnDefinition = "nvarchar(255)")
	private String tenNguoiDung;
	@Column(columnDefinition = "nvarchar(255)")
	private String diaChi;
	private String soDienThoai;
	
	@ManyToOne
	@JoinColumn(name = "nguoidung_id")
	private NguoiDung nguoiDung;
	
	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
	private List<CT_DonHang> dsChiTiet;
	
	public DonHang() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public List<CT_DonHang> getDsChiTiet() {
		return dsChiTiet;
	}

	public void setDsChiTiet(List<CT_DonHang> dsChiTiet) {
		this.dsChiTiet = dsChiTiet;
	}

	public String getPhuongThuc() {
		return phuongThuc;
	}

	public void setPhuongThuc(String phuongThuc) {
		this.phuongThuc = phuongThuc;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	
}
