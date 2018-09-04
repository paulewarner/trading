package com.sapient.trading.models;

public class User {
	String userId;
	String username;
	String password;
	//int enabled;

	public User(String userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		//this.enabled = enabled;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
//	public int getEnabled() {
//		return enabled;
//	}
//	public void setEnabled(int enabled) {
//		this.enabled = enabled;
//	}
	public void setPassword(String password) {
		this.password = password;
	}

}
