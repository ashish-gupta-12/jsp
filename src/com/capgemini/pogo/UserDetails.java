package com.capgemini.pogo;

public class UserDetails {
	String userName;
	String password;
	String userType;
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", password=" + password + ", userType=" + userType + "]";
	}
	public UserDetails(String userName, String password, String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
