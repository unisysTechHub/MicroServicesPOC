package com.example.demo.model;

import com.example.demo.service.model.Transaction;

public class TransactionResponseModel extends BaseResponse{
	 Transaction transactoin;

	public Transaction getTransactoin() {
		return transactoin;
	}

	public void setTransactoin(Transaction transactoin) {
		this.transactoin = transactoin;
	}
	 
}
