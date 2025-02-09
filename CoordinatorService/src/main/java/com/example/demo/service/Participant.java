package com.example.demo.service;

import com.example.demo.service.model.Transaction;

public interface Participant {
	    boolean prepare(Transaction transaction);
	    void commit();
	    void rollback();
}
