package com.example.demo;

import com.example.demo.model.TransactionModel;

public class TransactionResponseModel extends BaseResponse {

	TransactionModel transaction;

	public TransactionModel getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionModel transaction) {
		this.transaction = transaction;
	}

	

		
}
