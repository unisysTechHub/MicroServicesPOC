package com.example.demo.model;

import com.example.demo.service.model.Transaction;

public class TransactionPrepareResponse extends BaseResponse {
  Transaction transaction;

public Transaction getTransaction() {
	return transaction;
}

public void setTransaction(Transaction transaction) {
	this.transaction = transaction;
}



  
}
