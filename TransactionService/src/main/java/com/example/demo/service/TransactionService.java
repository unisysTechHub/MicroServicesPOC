package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.TransactionResponseModel;
import com.example.demo.entity.Transaction;
import com.example.demo.model.TransactionModel;
import com.example.demo.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo transactionRepo;
	
   public TransactionResponseModel prepare(TransactionModel transactionModel) {
	   //build and add Trnasction to Transaction Table with status PENDING
	  transactionRepo.save(new Transaction());
	  return new TransactionResponseModel();
   }
   
   void commit(String transactionId) {
	   // change traasction status to TransferPending 
   }
   
   void rollback(String transactionId) {
	   ///delete the Transaction with Pending 
   }
   
   
}
