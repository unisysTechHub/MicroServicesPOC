package com.poc.banking.UserService.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.banking.UserService.config.AppProperties;

@Component
public class URL {
	@Autowired
	AppProperties appProperties;
	String baseURL = appProperties.getCoordinatorServiceURL();
//	String port = appProperties.getServerPort();
//	public String baseURL =  String.format("http://%s:%d",url,port);
	public AppProperties getAppProperties() {
		return appProperties;
	}
	public void setAppProperties(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
	public String getCoordinatorService() {
		return baseURL + "/api/starttransfer";
	}
	
	
}
