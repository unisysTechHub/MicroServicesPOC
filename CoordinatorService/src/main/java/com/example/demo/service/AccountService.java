package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.model.Transaction;
public class AccountService implements Participant {
	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	public static String  urlPrepare = "http://localhost:8081/api/prepare";
	public static String  urlCommit = "http://localhost:8082/api/commit";
	public static String  urlRollback = "http://localhost:8082/api/rollback";
	private final Map<String, Double> accounts = new HashMap<>();
    private final Map<String, Double> reservedFunds = new HashMap<>();
    public AccountService() {
        accounts.put("acc1", 1000.0); // Example account with initial balance
    }

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
		String response = restTemplate.postForObject(uri, transaction, String.class);
    	
        return response.equals(PREPARED);
    }

    @Override
    public void commit(Transaction transaction) {
    	URI uri = null;
		try {
			uri = new URI(urlCommit);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, transaction, String.class);
    }

    @Override
    public void rollback(Transaction transaction) {
    	URI uri = null;
		try {
			uri = new URI(urlRollback);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, transaction, String.class);
    }

   
	

}
