package com.cts.policy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class PolicyMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroservicesApplication.class, args);
	}

}