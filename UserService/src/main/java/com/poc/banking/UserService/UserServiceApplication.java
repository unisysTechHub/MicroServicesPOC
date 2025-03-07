package com.poc.banking.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.poc.banking.UserService", "com.banking.auth.*"})
@EnableJpaRepositories(basePackages = {"com.banking.auth.repo","com.poc.banking.*"})
@EntityScan(basePackages = {"com.banking.auth.entity","com.poc.banking.*"})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
