package com.poc.banking.AdminService.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.poc.banking.AdminService.Response.BaseResponse;
import com.poc.banking.AdminService.Response.LoginResponse;
import com.poc.banking.AdminService.Response.SignupResponse;
import com.poc.banking.AdminService.entity.AdminDetails;
import com.poc.banking.AdminService.entity.query.AdminDetailsFluentQueryRepo;
import com.poc.banking.AdminService.entity.repository.AdminRepository;

@Service
public class ManageUserServiceImpl implements ManageUserService {
    private static final String TOPIC = "user-events";

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	AdminDetailsFluentQueryRepo queryRepo;
//	 @Autowired
//	    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public SignupResponse signup(AdminDetails admin) {
		SignupResponse response = new SignupResponse();
		 try {
			 AdminDetails adminDetails = adminRepo.save(admin);
			this.onSuccess(response,"200", "Admin User Sign up successfull");
			response.setUserId(adminDetails.getUserId());
 
		 }catch(Exception e) {
			 this.onError(response,"500", e.getLocalizedMessage());
		 }
		
		return  response;
		
	}
	@Override
	public LoginResponse login(AdminDetails admin) {
		LoginResponse response = new LoginResponse();
	  try {
		  boolean isValid =	queryRepo.isValidCredentials(admin);
		  
		    if (isValid) {
		    	this.onSuccess(response, "200", "Login Success full");
		    }
		    else {
		    	this.onError(response, "305", "invalid combination of userId and password");
		    }
		    
	  }catch(Exception e) {
	    	this.onError(response, "310", e.getLocalizedMessage());
	  }
	  
	 
		
		return response;
	}
	
	private void onSuccess(BaseResponse baseResponse, String responseCode, String message) {
		
		baseResponse.setMessage(message);
		baseResponse.setResponseCode(responseCode);
		
	}
	private void onError(BaseResponse baseResponse, String responseCode, String message) {
			
			baseResponse.setMessage(message);
			baseResponse.setResponseCode(responseCode);
			
		}
	  public void sendMessage(String message) {
	      //  kafkaTemplate.send(TOPIC, message);
	    }
}
