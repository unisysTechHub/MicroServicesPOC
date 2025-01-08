package com.poc.banking.UserService.response;

import com.poc.banking.UserService.entity.UserDetails;

public class NewUser extends BaseResponse {
	
	UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	

}
