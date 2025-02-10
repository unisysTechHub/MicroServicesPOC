package com.poc.banking.UserService.transfer.response;

import com.poc.banking.UserService.model.Transaction;
import com.poc.banking.UserService.response.BaseResponse;

public class TransactionResponseModel extends BaseResponse{
	 Transaction transactoin;

	public Transaction getTransactoin() {
		return transactoin;
	}

	public void setTransactoin(Transaction transactoin) {
		this.transactoin = transactoin;
	}
	 
}
