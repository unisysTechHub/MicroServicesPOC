package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.AppProperties;
import com.example.demo.service.model.Transaction;
@Service
public class AccountService implements Participant {
	 private final Log log = LogFactory.getLog(getClass()); 

	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	public static String  urlPrepare = "/api/account/prepare";
	public static String  urlCommit = "/api/account/commit";
	public static String  urlRollback = "/api/account/rollback";
	
	@Autowired
	AppProperties appProperties;
	private final Map<String, Double> accounts = new HashMap<>();
    private final Map<String, Double> reservedFunds = new HashMap<>();
    Transaction transaction;
    public AccountService() {
        accounts.put("acc1", 1000.0); // Example account with initial balance
    }

    @Override
    public boolean prepare(Transaction transaction) {
    		log.info("account service prepred method");
    		String accounService =this.appProperties.getAccountServiceUrl();
    	this.transaction = transaction;
    	URI uri = null;
		try {
			uri = new URI(accounService+urlPrepare);
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
    	log.info("account service prepred method");
    	String accounService =this.appProperties.getAccountServiceUrl();
    	log.info("account service commit method");
    	URI uri = null;
		try {
			uri = new URI(accounService+urlCommit);
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
    	log.info("account service prepred method");
    	String accounService = this.appProperties.getAccountServiceUrl();    	URI uri = null;
		try {
			uri = new URI(accounService+urlRollback);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, this.transaction, String.class);
		log.info("account service rollback respobse " + response );
    }

   
	

}
