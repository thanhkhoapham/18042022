package server.dto;

import java.io.Serializable;

public class NhaCungCapDTO implements Serializable {

	private static final long serialVersionUID = 3261071757219332630L;

	private int id;
	private String tenNhaCungCap;
	private String diaChi;
	private String soDienThoai;
	private boolean enable;

	public NhaCungCapDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public NhaCungCapDTO(int id, String tenNhaCungCap, String diaChi, String soDienThoai, boolean enable) {
		this.id = id;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.enable = enable;
	}

	public NhaCungCapDTO(String tenNhaCungCap, String diaChi, String soDienThoai, boolean enable) {
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.enable = enable;
	}

	public NhaCungCapDTO(int id, String tenNhaCungCap, String diaChi, String soDienThoai) {
		super();
		this.id = id;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

}
