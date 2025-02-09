package com.example.demo;

import com.example.demo.entity.Transaction;
import com.example.demo.model.TransactionModel;

public class TransactionResponseModel extends BaseResponse {

	TransactionModel transactionModel;

	public TransactionModel getTransactionModel() {
		return transactionModel;
	}

	public void setTransactionModel(TransactionModel transactionModel) {
		this.transactionModel = transactionModel;
	}

	

		
}
