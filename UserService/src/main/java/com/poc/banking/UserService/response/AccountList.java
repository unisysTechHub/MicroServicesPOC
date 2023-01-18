package com.poc.banking.UserService.response;

import java.util.List;

import com.poc.banking.UserService.entities.Account;

public class AccountList extends BaseResponse {
	
	List<Account> accountList;

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	

}
