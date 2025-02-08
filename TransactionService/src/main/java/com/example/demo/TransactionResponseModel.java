package com.example.demo;

import com.example.demo.entity.Transaction;

public class TransactionResponseModel extends BaseResponse{

	Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
}
