package com.samla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class configuration {

	
	@Bean
	public RestTemplate myRestTemplate() {
		return new RestTemplate();
	}
}
