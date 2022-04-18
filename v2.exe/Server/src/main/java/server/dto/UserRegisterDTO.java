package server.dto;

public class UserRegisterDTO {
	private int id;
	private String email;
	private String verificationCode;
	
	public UserRegisterDTO() {
	}	

	public UserRegisterDTO(int id, String email, String verificationCode) {
		super();
		this.id = id;
		this.email = email;
		this.verificationCode = verificationCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
}
