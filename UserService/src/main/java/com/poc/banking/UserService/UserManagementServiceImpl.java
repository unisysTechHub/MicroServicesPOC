package com.poc.banking.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.banking.UserService.entities.Account;
import com.poc.banking.UserService.response.AccountList;
import com.poc.banking.UserService.response.LoginResponse;
import com.poc.banking.UserService.response.NewUser;
import com.poc.banking.UserService.response.ValidateUserResponse;

import jakarta.transaction.Transactional;

@Service
public class UserManagementServiceImpl implements  UserManagementService {
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	UserDetailsFluentQueryAPI queryAPI;
	@Transactional
	@Override
	public NewUser addUser(UserDetails userDetails) {
		NewUser newUser = new  NewUser();

		try {
			System.out.println("@Rameseh " + userDetails.userId);
			//userDetails.setAccountList(null);
			userRepo.save(userDetails);
			newUser.setResponseCode("200");
			newUser.setMessage("Signup sucessfull");
			newUser.setUserDetails(userDetails);

		}
		catch(Exception e) {
			newUser.setResponseCode("400");
			newUser.setMessage("Signup unsucessfull" + e.getLocalizedMessage());
			
		}
		
		return newUser;
		
	}

	@Override
	public LoginResponse isValidCredintails(UserDetails userDetails) {	
		LoginResponse loginResponse = new LoginResponse();
		try {
			System.out.println("@Rameseh " + userDetails.userId);
			boolean validUser = queryAPI.isValidCredentials(userDetails);
			loginResponse.setUserId(userDetails.userId);
			 if (validUser == true) {
				 loginResponse.setResponseCode("200");
					loginResponse.setMessage("Login sucessfull");
			 }
			 else {
				 loginResponse.setResponseCode("304");
					loginResponse.setMessage("invalid combination of userid and pasword");
			 }
			 
			
		}
		catch(Exception e) {
			loginResponse.setResponseCode("305");
			loginResponse.setMessage("Login unsucessfull" + e.getLocalizedMessage());
		}
		return loginResponse;
	}
	
	
	@Override
	public ValidateUserResponse isValidUser(UserDetails userDetails) {	
		ValidateUserResponse validateUserResponse = new ValidateUserResponse();
		try {
			System.out.println("@Rameseh " + userDetails.userId);
			UserDetails user = queryAPI.isValidUser(userDetails);
			 if (user != null) {
				 validateUserResponse.setResponseCode("200");
				 validateUserResponse.setValidUser(true);
				 userDetails.setId(user.getId());
				 userDetails.setPassword(user.getPassword());
				// System.out.println("@Ramesh account id" + user.accountList.get(0).getAccountType());
				 validateUserResponse.setUserDetails(userDetails);
				 validateUserResponse.setMessage("User validation  sucessfull");
			 }
			 else {
				 validateUserResponse.setResponseCode("304");
				 validateUserResponse.setValidUser(false);
				 validateUserResponse.setMessage("userid is not exist");
			 }
			 
			
		}
		catch(Exception e) {
			validateUserResponse.setResponseCode("500");
			 validateUserResponse.setValidUser(false);
			validateUserResponse.setMessage("internal error" + e.getLocalizedMessage());
		}
		return validateUserResponse;
	}
	
	@Override
	public AccountList accountList(UserDetails userDetails) {	
		AccountList response = new AccountList();
		try {
			System.out.println("@Rameseh " + userDetails.userId);
			List<Account> accountsList = queryAPI.fetchUserDetilas(userDetails).getAccountList();
			 if (accountsList != null) {
				 response.setResponseCode("200");
				// System.out.println("@Ramesh account id" + accountsList.get(0).getAccountType());
				 response.setAccountList(accountsList);
				 response.setMessage("Accounts List ApI successfull");
			 }
			 else {
				 response.setResponseCode("304");
				 response.setMessage("Accounts are not exidst for the user " + userDetails.getUserId());
			 }
			 
			
		}
		catch(Exception e) {
			response.setResponseCode("500");
			response.setMessage("internal error" + e.getLocalizedMessage());
		}
		return response;
	}
	
}
