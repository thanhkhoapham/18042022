package client.dto;

public class UserLoginDTO {
	private String token;
	private int userId;
	private String userName;
	private boolean enable;
	
	public UserLoginDTO() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean status) {
		this.enable = status;
	}
	
	
}
