package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
	    org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.class
	})
public class CoordinatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordinatorServiceApplication.class, args);
	}

}
