package com.poc.banking.AccountService.service;

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
		
		Account account  = getAccount(transaction.getSenderAccount(),transaction.getUserDetails().getUserId());
		try {
		if((account.getAvailableBalance().compareTo(transaction.getAmount()) > 0) &&  
				account.getTransactoinStatus().equals(OPEN)) {
		
			account.setTransactoinStatus(PREPARED);
			
			return PREPARED;
			
		}
		else
		{
			return FAILED;
		}
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
	}
	@Transactional
	public String commit(Transaction transaction) {
		
		Account account  = getAccount(transaction.getSenderAccount(),transaction.getUserDetails().getUserId());
		try {
			if(account.getTransactoinStatus().equals(PREPARED)) {
			account.setAvailableBalance(transaction.getAmount());
			 accountRepo.save(account);
			 return "SUCCESS";
			}
			else {
			  return "ACCOUNT NOT PREPARED";	
			}
		
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
	}
	
	@Transactional
	public String rollback(Transaction transaction) {
		
		Account account  = getAccount(transaction.getSenderAccount(),transaction.getUserDetails().getUserId());
		try {
			if (account.getTransactoinStatus().equals(PREPARED)) {
				account.setTransactoinStatus(OPEN);;
				accountRepo.save(account);
				return "SUCCESS";
			}
			else {
				  return "ACCOUNT NOT PREPARED";
			}
			
			 
			 
		
		}catch(Exception e) {
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
