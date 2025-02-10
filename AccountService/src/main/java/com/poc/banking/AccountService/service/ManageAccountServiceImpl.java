package com.poc.banking.AccountService.service;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.poc.banking.AccountService.entity.Account;
import com.poc.banking.AccountService.entity.spec.AccountSpecifications;
import com.poc.banking.AccountService.model.Transaction;
import com.poc.banking.AccountService.repository.AccountRespository;
import com.poc.banking.AccountService.response.AddAccount;
import com.poc.banking.AccountService.response.BaseResponse;

import jakarta.transaction.Transactional;

@Service
public class ManageAccountServiceImpl implements ManageAccountService{
	 private final Log log = LogFactory.getLog(getClass()); 

    public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	@Autowired
	AccountRespository accountRepo;

	@Override
	public AddAccount addAccount(Account account) {
		// TODO Auto-generated method stub
		AddAccount addAccount = new AddAccount();
		try {
			accountRepo.save(account);
			addAccount.setAccount(account);
			this.onSuccess(addAccount,"200", "Account added successfully");
				
		}catch(Exception e) {
			this.onError(addAccount, "500", e.getLocalizedMessage());
		}
		return addAccount;
	}
	
	public void addTransactionAccount(Account account) {
		
	}
	
	@Transactional
	public String prepare(Transaction transaction) {
		log.info("Prepare method");
		log.debug("transfer Type " + transaction.getTransactionType().toString());
		 switch(transaction.getTransferType()) {
		case DomesticAch:
			//prepare sender account
			 
			break;
		case DomesticWire:
			//prepare sender account
			break;
		case INTERNAL:
			///prepare sender account
			//validate receiver account againt db  
			break;
		case INTRA:
			//prepare sender account
			//validate receiver account againt db  
			break;
		case International:
			//prepare sender account
			// handle both sender and receiver account 

			break;
		default:
			break;
		 
		 }
		Account account  = getAccount(transaction.getSenderAccount(),transaction.getUserDetails().getUserId());
		try {
		if(isEligibleForPreparation(account,transaction.getAmount())) {
		
			account.setTransactoinStatus(PREPARED);
			accountRepo.save(account);
			log.debug(PREPARED);
			
			return PREPARED;
			
		}
		else
		{
			log.debug(FAILED + " is not in Open status");
			return FAILED;
		}
		}catch(Exception e) {
			log.debug(e.getLocalizedMessage());
			return e.getLocalizedMessage();
		}
	}
	private boolean isEligibleForPreparation(Account account, BigDecimal transactionAmount) {
	    return account.getAvailableBalance().compareTo(transactionAmount) > 0 &&
	           OPEN.equals(account.getTransactoinStatus());
	}
	@Transactional
	public String commit(Transaction transaction) {
		log.info("commt method");
		Account account  = getAccount(transaction.getSenderAccount(),transaction.getUserDetails().getUserId());
		log.debug("get sender account successfull  " + account.getAccountNumber());
		try {
			if(account.getTransactoinStatus().equals(PREPARED)) {
			account.setTransactoinStatus("OPEN");
			 accountRepo.save(account);
			 log.debug("commit  succcess");
			 return "SUCCESS";
			}
			else {
				log.debug("account is not in prepared status - commit unsuccessful");
			  return "ACCOUNT NOT PREPARED";	
			}
		
		}catch(Exception e) {
			//set trnansaction open
			log.debug(e.getLocalizedMessage());
			return e.getLocalizedMessage();
		}
	}
	
	@Transactional
	public String rollback(Transaction transaction) {
		log.info("rollback method");
		Account account  = getAccount(transaction.getSenderAccount(),transaction.getUserDetails().getUserId());
		log.debug("get sender account successfull  " + account.getAccountNumber());

		try {
			if (account.getTransactoinStatus().equals(PREPARED)) {
				account.setTransactoinStatus(OPEN);;
				accountRepo.save(account);
				log.debug("roll back success ");
				
				return "SUCCESS";
			}
			else {
				log.debug("roll back - account is not in PREPARED status ");
				  return "ACCOUNT NOT PREPARED";
			}
			
			 
			 
		
		}catch(Exception e) {
			log.debug(e.getLocalizedMessage());
			return e.getLocalizedMessage();
		}
	}
	private Account getAccount(Long senderAccount, String userId) {
		return accountRepo.findOne(Specification.where(
	            AccountSpecifications.hasAccountId(senderAccount)
	            .and(AccountSpecifications.hasUserId(userId))
	        )).orElse(null);
	}
	
private void onSuccess(BaseResponse baseResponse, String responseCode, String message) {
		
		baseResponse.setMessage(message);
		baseResponse.setResponseCode(responseCode);
		
	}
	private void onError(BaseResponse baseResponse, String responseCode, String message) {
			
			baseResponse.setMessage(message);
			baseResponse.setResponseCode(responseCode);
			
		}

}
