package com.fish.provideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class ProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}

}
