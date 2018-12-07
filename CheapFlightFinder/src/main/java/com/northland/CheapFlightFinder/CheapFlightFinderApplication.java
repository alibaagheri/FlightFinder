package com.northland.CheapFlightFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Duration;

@SpringBootApplication
@EnableSwagger2
public class CheapFlightFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheapFlightFinderApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplateBuilder()
				.setReadTimeout(Duration.ofSeconds(30))
				.build();
	}
}
