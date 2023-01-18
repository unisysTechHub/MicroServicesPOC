package com.poc.banking.AccountService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.banking.AccountService.entity.Account;
import com.poc.banking.AccountService.repository.AccountRespository;
import com.poc.banking.AccountService.response.AddAccount;
import com.poc.banking.AccountService.response.BaseResponse;

@Service
public class ManageAccountServiceImpl implements ManageAccountService{
    
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
	
private void onSuccess(BaseResponse baseResponse, String responseCode, String message) {
		
		baseResponse.setMessage(message);
		baseResponse.setResponseCode(responseCode);
		
	}
	private void onError(BaseResponse baseResponse, String responseCode, String message) {
			
			baseResponse.setMessage(message);
			baseResponse.setResponseCode(responseCode);
			
		}

}
