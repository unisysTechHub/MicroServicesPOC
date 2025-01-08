package com.poc.banking.UserService;

import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.response.AccountList;
import com.poc.banking.UserService.response.LoginResponse;
import com.poc.banking.UserService.response.NewUser;
import com.poc.banking.UserService.response.ValidateUserResponse;

public interface UserManagementService {
	
	NewUser addUser(UserDetails userDetails);
	LoginResponse isValidCredintails(UserDetails userDetails);
    ValidateUserResponse isValidUser(UserDetails userDetails);
	AccountList accountList(UserDetails userDetails);
	public void consume(String message);

}
