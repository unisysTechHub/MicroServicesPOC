package com.poc.banking.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.banking.auth.entity.User;
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
	Optional<UserDetails> findByUserId(String username);
	NewUser addNewUser(User user);
	List<Map<String, String>> findRolesByUserName(String userName);

}
