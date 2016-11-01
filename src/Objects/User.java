package Objects;

public class User {

	
	public int userId;
	public String userName;
	String userEmail;
	String userAddress;
	public String userPassword;
	
	
	
	public User(int userId, String userName, String userEmail, String userAddress, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
	
	
}
