package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TransactionResponseModel;
import com.example.demo.model.TransactionIDGenerator;
import com.example.demo.model.TransactionModel;
import com.example.demo.service.TransactionService;

@RestController
public class MainController {
	 private final Log log = LogFactory.getLog(getClass()); 

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value= "/prepare", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	TransactionResponseModel prepare(@RequestBody TransactionModel transaction) {
		log.info("Request mapping - transactions ervice prepare method");
		 //update account with PREPARED or FAILED 
		//PREPARED - retrun PREAPRED
		
		//on error return Error message
		transaction.setTransactionId(TransactionIDGenerator.generateTransactionId());
		log.debug("Transaction id generated " + transaction.getTransactionId());
		
		return transactionService.prepare(transaction);
	}
	
	@RequestMapping(value= "/commit", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	String commit(@RequestBody TransactionModel transaction) {
		log.info("Request mapping - transactions service commit method");
		 //update account table - deduct balance - 
		// on successs - send SuCCESS
		//on error - send ERROR
		return transactionService.commit(transaction);
	}
	@RequestMapping(value= "/rollback", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	String rollback(@RequestBody TransactionModel transaction) {
		log.info("Request mapping - transactions service rollback method");
		 // update transctionAccount status as OPEN
		  // on Success - send ROLLBsUCCESS
		// Rerty policy later
		return transactionService.rollback(transaction);
	}
	
}
