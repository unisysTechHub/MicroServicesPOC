package com.example.demo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.TransactionResponseModel;
import com.example.demo.service.model.Transaction;

@Service
public class CoordinatorService  {
	 private final Log log = LogFactory.getLog(getClass()); 
     TransactionResponseModel transactionResponseModel;
	@Autowired
	private  List<Participant> services; // Participating services

    public TransactionResponseModel startTransaction(Transaction transaction) {
    	
        boolean allPrepared = true;

        for (Participant service : services) {
            boolean result = service.prepare(transaction);
            if (!result) {
                allPrepared = false;
                break;
            }
        }

        if (allPrepared) {
        	log.info(" account and transacion is prepared ");
            for (Participant service : services) {
                service.commit();
                if (service instanceof TransactionService) {
                    System.out.println("The service is an instance of Transaction.");
                    this.transactionResponseModel = ((TransactionService) service).transactionResponseModel;
                }
            }
            log.info(" account and transacion commit success");
            this.transactionResponseModel.setMessage("Transfer transaction successfull");
            return this.transactionResponseModel;
        } else {
            for (Participant service : services) {
                service.rollback();
            }
        	log.info(" account and transacion is rolledback ");
        	this.transactionResponseModel = new TransactionResponseModel(); 
        	this.transactionResponseModel.setTransaction(transaction);
        	this.transactionResponseModel.setResponseCode("304");
        	this.transactionResponseModel.setMessage("Transaction is not success full");
            return this.transactionResponseModel;
        }
    }




	public List<Participant> getServices() {
		return services;
	}




	public void setServices(List<Participant> services) {
		this.services = services;
	}




	

    
	
}
