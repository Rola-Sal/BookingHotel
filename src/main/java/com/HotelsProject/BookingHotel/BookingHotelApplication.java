package com.HotelsProject.BookingHotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class BookingHotelApplication {

	@Bean //the following methode that will be executed once
	@LoadBalanced //to do service discovery
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean //the following methode that will be executed once
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingHotelApplication.class, args);
	}

}
