package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TransactionResponseModel;
import com.example.demo.model.TransactionModel;
import com.example.demo.service.TransactionService;
import com.poc.banking.AccountService.model.Transaction;

@RestController
public class MainController {
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(value= "/prepare", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	TransactionResponseModel prepare(@RequestBody TransactionModel transaction) {
		
		 //update account with PREPARED or FAILED 
		//PREPARED - retrun PREAPRED
		
		//on error return Error message
		
		return transactionService.prepare(transaction);
	}
	
	@RequestMapping(value= "/commit", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	String commit(@RequestBody String transactionId) {
		 //update account table - deduct balance - 
		// on successs - send SuCCESS
		//on error - send ERROR
		return manageAccountService.commit(transaction);
	}
	@RequestMapping(value= "/rollback", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	String rollback(@RequestBody TransactionModel transaction) {
		 // update transctionAccount status as OPEN
		  // on Success - send ROLLBsUCCESS
		// Rerty policy later
		return manageAccountService.rollback(transaction);
	}
	
}
