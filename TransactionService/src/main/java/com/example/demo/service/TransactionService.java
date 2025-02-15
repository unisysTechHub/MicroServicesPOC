package com.example.demo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	// instead of storing in database - send to kafka tipic - can be scheduled to poll it 
	@Transactional
   public TransactionResponseModel prepare(TransactionModel transactionModel) {
		log.info("Prepare method");
	   
	   Transaction transaction = TransactionMapper.toEntity(transactionModel);
	   try {
		   transaction.setStatus(TransactionStatus.PREPARED);
		   logTransactionDetails(transaction);
		    transactionRepo.save(transaction);
	   }catch(DataIntegrityViolationException  e) {
		   TransactionResponseModel transactionResponseModel = new TransactionResponseModel();
		   transactionResponseModel.setMessage(FAILED);
		   transactionResponseModel.setResponseCode("304");
			log.debug(e.getLocalizedMessage());	   
		   return transactionResponseModel;
	   }
	   
	   TransactionResponseModel transactionResponseModel = new TransactionResponseModel();
	   transactionResponseModel.setMessage(PREPARED);
	   transactionResponseModel.setResponseCode("200");
	   transactionResponseModel.setTransaction(TransactionMapper.toModel(transaction));
	   log.info("Transaction updated in database" +transactionResponseModel.getTransaction().getTransactionId());
	  return transactionResponseModel;
   }
	private void logTransactionDetails(Transaction transaction) {
        System.out.println("----- Transaction Details Before Saving -----");
        System.out.println("ID: " + transaction.getId());
        System.out.println("Transaction ID: " + transaction.getTransactionId());
        System.out.println("Beneficiary ID: " + transaction.getBeneficiary().getId());
        System.out.println("Sender Account ID: " + transaction.getSenderAccount());
        System.out.println("Sender Account Type: " + transaction.getSenderAccountType());
        System.out.println("Receiver Account ID: " + transaction.getReceiverAccount());
        System.out.println("Receiver Account Type: " + transaction.getReceiverAccountType());
        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("User ID: " + (transaction.getUserDetails() != null ? transaction.getUserDetails().getId() : "N/A"));
        System.out.println("Transaction Type: " + transaction.getTransactionType());
        System.out.println("Transfer Type: " + transaction.getTransferType());
        System.out.println("Status: " + transaction.getStatus());
        System.out.println("Transaction Date: " + transaction.getTransactionDate());
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("Balance After Transaction: " + transaction.getBalanceAfterTransaction());
        System.out.println("---------------------------------------------");
    }
	@Transactional
   public String commit(TransactionModel transactionModel) {
		log.info("commit ");
	  // Transaction transaction = TransactionMapper.toEntity(transactionModel);
	  // TransactionMapper.updateTransactionStatus(transaction, TransactionStatus.TransferPending);
	   try {
		   String transactionId = transactionModel.getTransactionId();
		   transactionRepo.updateTransactionStatus(Long.parseLong(transactionId), TransactionStatus.TransferPending);
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
//	   Transaction transaction = TransactionMapper.toEntity(transactionModel);
	//   TransactionMapper.updateTransactionStatus(transaction, TransactionStatus.FAILED);
	   try {
		   String transactionId = transactionModel.getTransactionId();
		   transactionRepo.updateTransactionStatus(Long.parseLong(transactionId), TransactionStatus.FAILED);
		//   transactionRepo.save(transaction);
		   log.debug("updated failed status");
		   return "SUCCESS";
	   }
	   catch(Exception e) {
		   log.debug("rollback - update failed status failed" + e.getLocalizedMessage());
		   return e.getLocalizedMessage();
		
	   }
	   
   }
   
 }
   
   

