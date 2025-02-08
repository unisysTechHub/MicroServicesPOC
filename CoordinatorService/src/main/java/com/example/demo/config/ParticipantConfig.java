package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.AccountService;
import com.example.demo.service.Participant;
import com.example.demo.service.TransactionService;

import java.util.List;

@Configuration
public class ParticipantConfig {

    @Bean
    public List<Participant> participantServices() {
        return List.of(new TransactionService(), new AccountService());
    }
}
