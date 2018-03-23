package com.fd.configserver.ConfigserverLocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverLocalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverLocalApplication.class, args);
	}
}
