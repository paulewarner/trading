package com.sapient.trading.models;

public class Authority {
	String userId;
	String accountType;
	public Authority(String userId, String accountType) {
		super();
		this.userId = userId;
		this.accountType = accountType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
