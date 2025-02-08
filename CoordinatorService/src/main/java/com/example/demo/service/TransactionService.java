package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TransactionPrepareResponse;
import com.example.demo.service.model.Transaction;

public class TransactionService implements Participant{
	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	public static String  urlPrepare = "http://localhost:8082/api/prepare";
	public static String  urlCommit = "http://localhost:8082/api/commit";
	public static String  urlRollback = "http://localhost:8082/api/rollback";
	String transactionId;
	@Override
    public boolean prepare(Transaction transaction) {
    	URI uri = null;
		try {
			uri = new URI(urlPrepare);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		TransactionPrepareResponse response = restTemplate.postForObject(uri, transaction, TransactionPrepareResponse.class);
    	this.transactionId = response.getTransactoinId();
        return response.getStatus().equals(PREPARED);
    }

    @Override
    public void commit(String transactionId) {
    	URI uri = null;
		try {
			uri = new URI(urlCommit);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, transactionId, String.class);
    }

    @Override
    public void rollback(String transactionId) {
    	URI uri = null;
		try {
			uri = new URI(urlRollback);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, transactionId, String.class);
    }

   
	
    
}
