package com.poc.banking.UserService.response;

import java.io.Serializable;

import com.poc.banking.UserService.UserDetails;

public class ValidateUserResponse extends BaseResponse {
	boolean isValidUser;
	UserDetails userDetails;

	public boolean isValidUser() {
		return isValidUser;
	}

	public void setValidUser(boolean isValidUser) {
		this.isValidUser = isValidUser;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
