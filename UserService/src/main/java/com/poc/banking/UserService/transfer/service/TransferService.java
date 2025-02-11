package com.poc.banking.UserService.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poc.banking.UserService.UserManagementService;
import com.poc.banking.UserService.model.Transaction;
import com.poc.banking.UserService.model.URL;
import com.poc.banking.UserService.transfer.response.TransactionResponseModel;

@Service
public class TransferService {

	@Autowired
	UserManagementService userManagementService; 
	
	public TransactionResponseModel startTrasnaction(Transaction transaction) {
		//validate authenticate user
		// validate // transaction data againt userdetails, account, beneficiary table
		RestTemplate resttemplate  = new RestTemplate();
		return resttemplate.postForObject(URL.coordinatorService,transaction,TransactionResponseModel.class );
	}
}
