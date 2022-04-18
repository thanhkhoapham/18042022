package server.dto;

public class UserDTO {
	private int id;
	private String tenNguoiDung;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String verificationCode;
	private boolean enable;
	private String matKhau;

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public UserDTO(String tenNguoiDung, String diaChi, String soDienThoai, String email, String matKhau) {
		this.tenNguoiDung = tenNguoiDung;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.verificationCode = null;
		this.enable = true;
		this.matKhau = matKhau;
	}

	public UserDTO(int id, String tenNguoiDung, String diaChi, String soDienThoai, String email,
			String verificationCode, boolean enable) {
		this.id = id;
		this.tenNguoiDung = tenNguoiDung;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.verificationCode = verificationCode;
		this.enable = enable;
	}

	public UserDTO() {
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", tenNguoiDung=" + tenNguoiDung + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", verificationCode=" + verificationCode + ", enable=" + enable
				+ "]";
	}

}
