package com.poc.banking.UserService.response;

public class LoginResponse extends BaseResponse {
	String userId;
	String jwt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
