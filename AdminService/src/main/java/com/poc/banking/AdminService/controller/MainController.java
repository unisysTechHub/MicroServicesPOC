package com.poc.banking.AdminService.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc.banking.AdminService.Response.BaseResponse;
import com.poc.banking.AdminService.Response.LoginResponse;
import com.poc.banking.AdminService.Response.SignupResponse;
import com.poc.banking.AdminService.entity.AdminDetails;
import com.poc.banking.AdminService.service.ManageUserService;



@RestController
@RequestMapping(value = "/api/admin")
public class MainController {

	@Autowired
	ManageUserService manageUserService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	SignupResponse addUser(@RequestBody AdminDetails admin) {
		System.out.println("@Rameseh controller " + admin.getUserId());
		return manageUserService.signup(admin);
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	LoginResponse login(@RequestBody AdminDetails admin) {
		System.out.println("@Rameseh controller " + admin.getUserId());
		//customer();
		return manageUserService.login(admin);
		
	}
	
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	LoginResponse addAccount(@RequestBody AdminDetails admin) {
		System.out.println("@Rameseh controller " + admin.getUserId());
		
		// on successful Admin Login with credentials
		// validate userId of the  account to be added - RestTemplate UserService - validateUser API
		// On successful validate user API - call RestTemplate AccountService - add account API
		//customer();
		return manageUserService.login(admin);
		
	}
	
	
	void customer() {
		
		RestTemplate restTemplate	=  new RestTemplate();
		try {
			URI uri =  new URI("http://localhost:8082/api/login");
			AdminDetails user =  new AdminDetails();
			user.setUserId("Ramesh12");
			user.setPassword("Ramesh12");
		BaseResponse response =	restTemplate.postForObject(uri,user , BaseResponse.class);
		System.out.println("@Ramesh" + response.getMessage());

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
