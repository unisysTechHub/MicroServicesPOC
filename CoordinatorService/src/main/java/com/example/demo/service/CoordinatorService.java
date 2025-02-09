package com.example.demo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.service.model.Transaction;

@Service
public class CoordinatorService  {
	 private final Log log = LogFactory.getLog(getClass()); 

	@Autowired
	private  List<Participant> services; // Participating services

    public String startTransaction(Transaction transaction) {
    	
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
            }
            return "Transaction Committed";
        } else {
            for (Participant service : services) {
                service.rollback();
            }
        	log.info(" account and transacion is rolledback ");
            return "Transaction Rolled Back";
        }
    }




	public List<Participant> getServices() {
		return services;
	}




	public void setServices(List<Participant> services) {
		this.services = services;
	}




	

    
	
}
