package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "")
public class AppProperties {
    private String TRANSACTION_SERVICE_URL;
    private String ACCOUNT_SERVICE_URL;
	public String getTRANSACTION_SERVICE_URL() {
		return TRANSACTION_SERVICE_URL;
	}
	public void setTRANSACTION_SERVICE_URL(String tRANSACTION_SERVICE_URL) {
		TRANSACTION_SERVICE_URL = tRANSACTION_SERVICE_URL;
	}
	public String getACCOUNT_SERVICE_URL() {
		return ACCOUNT_SERVICE_URL;
	}
	public void setACCOUNT_SERVICE_URL(String aCCOUNT_SERVICE_URL) {
		ACCOUNT_SERVICE_URL = aCCOUNT_SERVICE_URL;
	}

   
}
