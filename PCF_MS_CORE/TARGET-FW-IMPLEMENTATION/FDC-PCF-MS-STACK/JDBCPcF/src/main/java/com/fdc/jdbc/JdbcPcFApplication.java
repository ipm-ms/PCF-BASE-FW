package com.fdc.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fdc.jdbc.repository.AccountRepository;

@SpringBootApplication
public class JdbcPcFApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcPcFApplication.class, args);
	}
	
}
