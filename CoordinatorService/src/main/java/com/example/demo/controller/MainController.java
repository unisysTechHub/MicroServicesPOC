package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CoordinatorService;
import com.example.demo.service.model.Transaction;

@RestController
@RequestMapping(value = "/api")
public class MainController {
	@Autowired
	CoordinatorService coordinatorService;
	 private final Log log = LogFactory.getLog(getClass()); 
	@PostMapping(value = "/transfer", consumes = "application/json")
	public Transaction startTransfer(Transaction transaction) {
		log.info("Co orditnore service - startTransfer method ");
		log.debug("Co ordinator service " + transaction.getSenderAccount() +  "receiver account " + transaction.getReceiverAccount());
		coordinatorService.startTransaction(transaction);
			return transaction;
	}
}
