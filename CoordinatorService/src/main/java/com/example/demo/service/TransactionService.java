package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TransactionPrepareResponse;
import com.example.demo.service.model.Transaction;

public class TransactionService implements Participant{
	 private final Log log = LogFactory.getLog(getClass()); 

	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	public static String  urlPrepare = "http://localhost:8082/api/prepare";
	public static String  urlCommit = "http://localhost:8082/api/commit";
	public static String  urlRollback = "http://localhost:8082/api/rollback";
	Transaction transaction;
	String transactionId;
	@Override
    public boolean prepare(Transaction transaction) {
		log.info("transaction service prepared method");
    	URI uri = null;
		try {
			uri = new URI(urlPrepare);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		TransactionPrepareResponse response = restTemplate.postForObject(uri, transaction, TransactionPrepareResponse.class);
    	this.transactionId = response.getTransactoin().getTransactionId();
    	log.debug("tranasction service prepared response transaction id " + response.getTransactoin().getTransactionId());
    	log.debug("tranasction service prepared response status " + response.getStatus());
    	this.transaction = response.getTransactoin();
          return response.getStatus().equals(PREPARED);
    }

    @Override
    public void commit() {
		log.info("transaction service commit method");

    	URI uri = null;
		try {
			uri = new URI(urlCommit);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, this.transaction, String.class);
		log.info("transaction service commit response" + response);
    }

    @Override
    public void rollback() {
		log.info("transaction service rollback method");

    	URI uri = null;
		try {
			uri = new URI(urlRollback);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, this.transaction, String.class);
		log.info("transaction service rollback response " + response);

    }

   
	
    
}
