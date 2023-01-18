package com.poc.banking.AccountService.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc.banking.AccountService.entity.Account;
import com.poc.banking.AccountService.entity.UserDetails;
import com.poc.banking.AccountService.response.AddAccount;
import com.poc.banking.AccountService.response.BaseResponse;
import com.poc.banking.AccountService.response.ValidateUserResponse;
import com.poc.banking.AccountService.service.ManageAccountService;
import com.poc.banking.AccountService.url.URL;

@RestController
@RequestMapping(value= "api/account")
public class MainController {
	
	@Autowired
	ManageAccountService manageAccountService;

	@RequestMapping(value= "/addaccount", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	AddAccount addAccount(@RequestBody Account account) {
		AddAccount addAccount = new AddAccount();
		System.out.println("@Ramesh " + account.getUserDetails().getUserId());
		ValidateUserResponse response = this.isValidUser(account.getUserDetails());
		if (response.isValidUser()) {
			setUserDetials(response,account);
			System.out.println("@Ramesh add account" + response.getUserDetails().getPassword());
			addAccount = manageAccountService.addAccount(account);
		}
		else {
			addAccount.setResponseCode("310");
			addAccount.setMessage("User id is not exists");
		}
		return addAccount;
	}
	
	private ValidateUserResponse isValidUser(UserDetails user)  {
		RestTemplate restTemplate	=  new RestTemplate();
		ValidateUserResponse reponse = new ValidateUserResponse();
		try {
			URI uri = new URI(URL.userService);
			//System.out.println("@Ramesh" + response.getMessage());

			reponse = restTemplate.postForObject(uri,user , ValidateUserResponse.class);
	

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reponse;
		
	}
	
	
	void setUserDetials(ValidateUserResponse response,Account account) {
		if (response.isValidUser()) {
			account.setUserDetails(response.getUserDetails());
			
		}
	}
}
