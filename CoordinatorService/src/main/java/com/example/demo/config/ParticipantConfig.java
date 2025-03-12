package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.AccountService;
import com.example.demo.service.Participant;
import com.example.demo.service.TransactionService;

import java.util.List;

@Configuration
public class ParticipantConfig {
 
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountService accountService;
    @Bean
    public List<Participant> participantServices() {
    	
        return List.of(transactionService, accountService);
    }
}
