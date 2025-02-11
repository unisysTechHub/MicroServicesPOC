package com.poc.banking.UserService.transfer.response;

import com.poc.banking.UserService.model.Transaction;
import com.poc.banking.UserService.response.BaseResponse;

public class TransactionResponseModel extends BaseResponse{
	 Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	 
}
