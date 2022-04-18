package server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "san_pham")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "loai_sanpham")
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4217713153397349873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String tenSanPham;
	private double gia;
	@Column(columnDefinition = "nvarchar(255)")
	private String moTa;
	private String urlHinhAnh;
	private boolean enable;
	
	@ManyToOne
	@JoinColumn(name = "nhacungcap_id")
	private NhaCungCap nhaCungCap;
	
	@ManyToOne
	@JoinColumn(name = "hangsx_id")
	private HangSanXuat hangSanXuat;
	
	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
	private List<CT_DonHang> dsChiTiet;
	
	public SanPham() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getUrlHinhAnh() {
		return urlHinhAnh;
	}

	public void setUrlHinhAnh(String urlHinhAnh) {
		this.urlHinhAnh = urlHinhAnh;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public List<CT_DonHang> getDsChiTiet() {
		return dsChiTiet;
	}

	public void setDsChiTiet(List<CT_DonHang> dsChiTiet) {
		this.dsChiTiet = dsChiTiet;
	}
	
	
}
