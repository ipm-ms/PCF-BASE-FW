package com.fdc.account.bl;

import java.net.SocketTimeoutException;
import java.util.UUID;

import org.apache.http.conn.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

import com.fdc.account.bo.AccountBO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RefreshScope
@Service("contanerManagedAccountBL")
public class AccountBL {
	private static final Logger logger = LoggerFactory.getLogger(AccountBL.class);
	@Autowired
	private RestTemplate restTemplate;

	@Value("${accountds.intergration_service_name:ACCOUNT-INTEGRATION-SERVICE}")
	private String ACCOUNT_INTEGRATION_SERVICE;

	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5") }, fallbackMethod = "getDefaultAccount")
	public AccountBO getAccount(String id) throws Exception {

		try {
			String URL = String.format("http://%s/search/{id}", ACCOUNT_INTEGRATION_SERVICE);
			AccountBO account = restTemplate
					.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<AccountBO>() {
					}, id).getBody();
			return account;
		} catch (RestClientException e) {
			if (e.getRootCause() instanceof SocketTimeoutException) {
				logger.error("SocketTimeoutException", e);
			} else if (e.getRootCause() instanceof ConnectTimeoutException) {
				logger.error("ConnectTimeoutException", e);
			}
			throw new RuntimeException(e);
			// throw e;
		}
	}

	public AccountBO getDefaultAccount(String id) {
		logger.debug("----------------IN FALLBACK METHOD---------------------------");
		return new AccountBO(UUID.randomUUID().toString(), "THIS IS A DUMMY ACCOUNT", "DUMMY-ACCOUNT");
	}
}
