package com.example.demo.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.AppProperties;
import com.example.demo.model.TransactionPrepareResponse;
import com.example.demo.model.TransactionResponseModel;
import com.example.demo.service.model.Transaction;
@Service
public class TransactionService implements Participant{
	 private final Log log = LogFactory.getLog(getClass()); 

	public static String PREPARED = "PREPARED";
    public static String FAILED = "FAILED";
    public static String OPEN = "OPEN";
	public static String  urlPrepare = "/api/prepare";
	public static String  urlCommit = "/api/commit";
	public static String  urlRollback = "/api/rollback";
	Transaction transaction;
	String transactionId;
	@Autowired
	RestTemplate restTemplate;
	TransactionResponseModel transactionResponseModel;
	AppProperties appProperties;
	@Override
    public boolean prepare(Transaction transaction) {
		log.info("transaction service prepared method");
		this.transaction = transaction;
    	String transacionService = appProperties.getTransactionServiceUrl();
		String urlprepare = transacionService + urlPrepare;
		TransactionPrepareResponse response = null;
		 try {
		 response = restTemplate.postForObject(urlprepare, transaction, TransactionPrepareResponse.class);
		 } catch (HttpClientErrorException e) {
		        // 4xx errors
		        log.error("Client error: {}", e);
		        throw e;
		    } catch (HttpServerErrorException e) {
		        // 5xx errors
		        log.error("Server error: {}", e);
		        throw e;
		    } catch (Exception e) {
		        log.error("Unexpected error: {}", e);
		        throw new RuntimeException("Failed to prepare transaction", e);
		    }
    	this.transactionId = response.getTransaction().getTransactionId();
   
    	log.debug("tranasction service prepared response transaction id " + response.getTransaction().getTransactionId());
    	log.debug("tranasction service prepared response status " + response.getMessage());
     
    	this.transactionResponseModel = buildResponse(response);
     	this.transaction = response.getTransaction();
          return response.getMessage().equals(PREPARED);
    }

	TransactionResponseModel buildResponse(TransactionPrepareResponse prepareResponse) {
        if (prepareResponse == null || prepareResponse.getTransaction() == null) {
            throw new IllegalArgumentException("Invalid TransactionPrepareResponse provided.");
        }

        Transaction transaction = prepareResponse.getTransaction();
        TransactionResponseModel responseModel = new TransactionResponseModel();
        responseModel.setTransaction(transaction);
        responseModel.setResponseCode(prepareResponse.getResponseCode());
        responseModel.setMessage(prepareResponse.getMessage());
        
        return responseModel;
    }
    @Override
    public void commit() {
		log.info("transaction service commit method");
    	String transacionService = appProperties.getTransactionServiceUrl();

    	URI uri = null;
		try {
			uri = new URI(transacionService+urlCommit);
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
    	String transacionService = appProperties.getTransactionServiceUrl();

    	URI uri = null;
		try {
			uri = new URI(transacionService+urlRollback);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(uri, this.transaction, String.class);
		log.info("transaction service rollback response " + response);

    }

   
	
    
}
