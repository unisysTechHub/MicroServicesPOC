package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.model.Transaction;
public class AccountService implements Participant {
	 private final Log log = LogFactory.getLog(getClass()); 

	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	public static String  urlPrepare = "http://localhost:8081/api/prepare";
	public static String  urlCommit = "http://localhost:8082/api/commit";
	public static String  urlRollback = "http://localhost:8082/api/rollback";
	private final Map<String, Double> accounts = new HashMap<>();
    private final Map<String, Double> reservedFunds = new HashMap<>();
    Transaction transaction;
    public AccountService() {
        accounts.put("acc1", 1000.0); // Example account with initial balance
    }

    @Override
    public boolean prepare(Transaction transaction) {
    		log.info("account service prepred method");
    	this.transaction = transaction;
    	URI uri = null;
		try {
			uri = new URI(urlPrepare);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, transaction, String.class);
		log.debug("account service prepred method " + response);
        return response.equals(PREPARED);
    }

    @Override
    public void commit() {
    	log.info("account service commit method");
    	URI uri = null;
		try {
			uri = new URI(urlCommit);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, this.transaction, String.class);
		log.info("account service commit respobse " + response );
    }

    @Override
    public void rollback() {
    	log.info("account service rollback method");
    	URI uri = null;
		try {
			uri = new URI(urlRollback);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, this.transaction, String.class);
		log.info("account service rollback respobse " + response );
    }

   
	

}
