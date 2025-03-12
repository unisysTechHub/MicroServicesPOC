package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppProperties {

	@Autowired
    private  Environment env;

    @Value("${TRANSACTION_SERVICE_URL}")
    private String transactionServiceUrl;
    
    @Value("${ACCOUNT_SERVICE_URL}")
    private String accountServiceUrl;

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getTransactionServiceUrl() {
		return transactionServiceUrl;
	}

	public void setTransactionServiceUrl(String transactionServiceUrl) {
		this.transactionServiceUrl = transactionServiceUrl;
	}

	public String getAccountServiceUrl() {
		return accountServiceUrl;
	}

	public void setAccountServiceUrl(String accountServiceUrl) {
		this.accountServiceUrl = accountServiceUrl;
	}

		
    
        
}
