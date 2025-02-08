package com.example.demo.controller;

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

	@PostMapping(value = "/transfer", consumes = "application/json")
	public Transaction startTransfer(Transaction transaction) {
		coordinatorService.startTransaction(transaction);
			return transaction;
	}
}
