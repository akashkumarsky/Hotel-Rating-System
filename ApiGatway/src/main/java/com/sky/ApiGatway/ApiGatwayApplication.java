package com.sky.ApiGatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ApiGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatwayApplication.class, args);
	}

}