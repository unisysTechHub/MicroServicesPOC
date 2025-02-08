package com.example.demo.service;

import com.example.demo.service.model.Transaction;

public interface Participant {
	    boolean prepare(Transaction transactionId);
	    void commit(String transactionId);
	    void rollback(String transactionId);
}
