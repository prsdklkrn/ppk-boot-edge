package com.ppk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.ppk.ribbon.config.CustomRibbonClient;

@SpringBootApplication
@CustomRibbonClient
@EnableFeignClients(value = "com.ppk.feign")
@EnableCircuitBreaker
public class EdgeDataMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeDataMainApplication.class, args);
	}

}
