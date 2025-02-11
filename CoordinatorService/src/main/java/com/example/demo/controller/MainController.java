package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TransactionResponseModel;
import com.example.demo.service.CoordinatorService;
import com.example.demo.service.model.Transaction;

@RestController
@RequestMapping(value = "/api")
public class MainController {
	@Autowired
	CoordinatorService coordinatorService;
	 private final Log log = LogFactory.getLog(getClass()); 
	@PostMapping(value = "/starttransfer", consumes = "application/json")
	public TransactionResponseModel startTransfer(@RequestBody Transaction transaction) {
		log.info("Co orditnore service - startTransfer method ");
		log.debug("Co ordinator service " + transaction.getUserDetails().getUserId() +  "Benfeficiar id " + transaction.getBeneficiary().getId());
	return	coordinatorService.startTransaction(transaction);
			
	}
}
