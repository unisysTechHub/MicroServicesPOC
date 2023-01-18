package com.poc.banking.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.banking.UserService.response.AccountList;
import com.poc.banking.UserService.response.LoginResponse;
import com.poc.banking.UserService.response.NewUser;
import com.poc.banking.UserService.response.ValidateUserResponse;

@RestController
@RequestMapping(value = "/api/user")
public class MainConroller {

	@Autowired
	UserManagementService userManagementService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	NewUser addUser(@RequestBody UserDetails user) {
		System.out.println("@Rameseh controller " + user.userId);
		return userManagementService.addUser(user);
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	LoginResponse login(@RequestBody UserDetails user) {
		System.out.println("@Rameseh controller " + user.password);

		return userManagementService.isValidCredintails(user);
		
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	AccountList accounts(@RequestBody UserDetails user) {
		System.out.println("@Rameseh controller " + user.userId);
		LoginResponse response =	userManagementService.isValidCredintails(user);
		AccountList acctResponse = new AccountList();
		
		switch (response.getResponseCode()) {
		 
		 case "200" : 
			 acctResponse	 = userManagementService.accountList(user);
		 default :
			 acctResponse.setResponseCode(response.getResponseCode());
			 acctResponse.setMessage(response.getMessage());
		 }
		  
						
		return  acctResponse;
		
	}
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	ValidateUserResponse validateUser(@RequestBody UserDetails user) {
		System.out.println("@Rameseh controller " + user.userId);	 
		return userManagementService.isValidUser(user);
		
	}
	
}
