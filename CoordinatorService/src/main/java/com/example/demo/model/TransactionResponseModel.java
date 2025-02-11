package com.example.demo.model;

import com.example.demo.service.model.Transaction;

public class TransactionResponseModel extends BaseResponse{
	 Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	
	 
}
