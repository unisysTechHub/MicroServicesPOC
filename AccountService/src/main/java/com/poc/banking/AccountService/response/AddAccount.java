package com.poc.banking.AccountService.response;

import com.poc.banking.AccountService.entity.Account;

public class AddAccount  extends BaseResponse {

	Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
