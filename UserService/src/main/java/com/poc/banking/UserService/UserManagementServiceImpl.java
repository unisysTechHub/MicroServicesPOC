package com.poc.banking.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.poc.banking.UserService.entity.Account;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.kafka.ListenerInspector;
import com.poc.banking.UserService.repo.UserRepository;
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
			System.out.println("@Rameseh " + userDetails.getUserId());
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
			System.out.println("@Rameseh " + userDetails.getUserId());
			boolean validUser = queryAPI.isValidCredentials(userDetails);
			loginResponse.setUserId(userDetails.getUserId());
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
		System.out.println("@Rameseh isValidUser entry " + userDetails.getUserId());
		ValidateUserResponse validateUserResponse = new ValidateUserResponse();
		try {
			System.out.println("@Rameseh is valid user " + userDetails.getUserId());
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
		int[] intarray = new int[10];
		ArrayList<Integer> arrayList = new ArrayList<Integer>(10);
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		
		for(int i = 0;i< 4;i++){
			Integer integer = 10;
			System.out.print(integer.intValue());
			int j = i++;
			System.out.println(i +"");;
		}
				
		try {
			System.out.println("@Rameseh account list " + userDetails.getUserId());
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
	 @KafkaListener(id = "userEventsListener",topics = "user-events", groupId = "group_id")
	    public void consume(String message) {
	        System.out.println("@Ramesh Consumed message: " + message);
	        // Process the message
	    }
	
}
