package com.fdc.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class AccountDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDsApplication.class, args);
	}
}
