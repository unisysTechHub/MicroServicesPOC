package com.example.demo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.TransactionResponseModel;
import com.example.demo.entity.Transaction;
import com.example.demo.model.TransactionModel;
import com.example.demo.model.TransactionStatus;
import com.example.demo.repo.TransactionRepo;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	 private final Log log = LogFactory.getLog(getClass()); 

	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	@Autowired
	TransactionRepo transactionRepo;
	
	@Transactional
   public TransactionResponseModel prepare(TransactionModel transactionModel) {
		log.info("Prepare method");
	   //build and add Trnasction to Transaction Table with status PENDING
	   Transaction transaction = TransactionMapper.toEntity(transactionModel);
	   try {
		   transactionRepo.save(transaction);
	   }catch(Exception e) {
		   TransactionResponseModel transactionResponseModel = new TransactionResponseModel();
		   transactionResponseModel.setStatus(FAILED);
			log.debug(e.getLocalizedMessage());	   
		   return transactionResponseModel;
	   }
	  
	   TransactionResponseModel transactionResponseModel = new TransactionResponseModel();
	   transactionResponseModel.setStatus(PREPARED);
	   transactionResponseModel.setTransactionModel(TransactionMapper.toModel(transaction));
	   log.debug("Transaction updated in database" + transaction.getTransactionId());
	  return transactionResponseModel;
   }
	
	@Transactional
   public String commit(TransactionModel transactionModel) {
		log.info("commit ");
	   Transaction transaction = TransactionMapper.toEntity(transactionModel);
	   TransactionMapper.updateTransactionStatus(transaction, TransactionStatus.TransferPending);
	   try {
		   transactionRepo.save(transaction);
		   log.info("commit sucess - transfer pending udpated");
		   return "SUCCESS";
	   }catch(Exception e) {
		   log.debug("updating transfer pending failed" + e.getLocalizedMessage());
		   return e.getLocalizedMessage();
	   }
	   
   }
   
	@Transactional
   public String rollback(TransactionModel transactionModel) {
		log.debug("rollback");
	   Transaction transaction = TransactionMapper.toEntity(transactionModel);
	   TransactionMapper.updateTransactionStatus(transaction, TransactionStatus.FAILED);
	   try {
		   transactionRepo.save(transaction);
		   log.debug("updated failed status");
		   return "SUCCESS";
	   }
	   catch(Exception e) {
		   log.debug("rollback - update failed status failed" + e.getLocalizedMessage());
		   return e.getLocalizedMessage();
		
	   }
	   
   }
   
 }
   
   

