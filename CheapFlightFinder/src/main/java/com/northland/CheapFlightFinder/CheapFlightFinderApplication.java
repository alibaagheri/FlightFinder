package com.northland.CheapFlightFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CheapFlightFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheapFlightFinderApplication.class, args);
	}

	RestTemplate restTemplate = new RestTemplate();
}
