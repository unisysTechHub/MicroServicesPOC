package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.service.model.Transaction;

@Service
public class CoordinatorService  {

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
            for (Participant service : services) {
                service.commit(transaction);
            }
            return "Transaction Committed";
        } else {
            for (Participant service : services) {
                service.rollback(transaction);
            }
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
