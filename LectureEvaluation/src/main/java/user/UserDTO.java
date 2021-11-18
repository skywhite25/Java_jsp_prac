package user;

public class UserDTO {
	
	private String userID;
	private String userPW;
	private String userEmail;
	private String userEmailHash;
	private boolean userEmailChecked;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmailHash() {
		return userEmailHash;
	}
	public void setUserEmailHash(String userEmailHash) {
		this.userEmailHash = userEmailHash;
	}

	public boolean isUserEmailChecked() {
		return userEmailChecked;
	}
	public void setUserEmailChecked(boolean userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userID=" + userID + ", userPW=" + userPW + ", userEmail=" + userEmail + ", userEmailHash="
				+ userEmailHash + ", userEmailChecked=" + userEmailChecked + "]";
	}
	
	public UserDTO(String userID, String userPassword, String userEmail,
			String userEmailHash, boolean userEmailChecked) {

		this.userID = userID;
		this.userPW = userPassword;
		this.userEmail = userEmail;
		this.userEmailHash = userEmailHash;
		this.userEmailChecked = userEmailChecked;

	}



}
