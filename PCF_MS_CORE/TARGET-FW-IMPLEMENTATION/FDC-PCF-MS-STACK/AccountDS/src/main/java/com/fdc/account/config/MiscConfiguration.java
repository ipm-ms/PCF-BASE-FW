package com.fdc.account.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MiscConfiguration {
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
				.getRequestFactory();
		rf.setReadTimeout(3 * 1000);
		rf.setConnectTimeout(3 * 1000);		
		return restTemplate;
	}

}
