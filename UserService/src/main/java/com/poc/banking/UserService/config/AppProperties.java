package com.poc.banking.UserService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class AppProperties {
	@Value("${COORDINAOR_SERICE_URL}")
	String coordinatorServiceURL;
	
	@Value("${server.port}")
	String serverPort;

	public String getCoordinatorServiceURL() {
		return coordinatorServiceURL;
	}

	public void setCoordinatorServiceURL(String coordinatorServiceURL) {
		this.coordinatorServiceURL = coordinatorServiceURL;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	
		
}
