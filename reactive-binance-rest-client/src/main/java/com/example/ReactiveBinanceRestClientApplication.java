package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReactiveBinanceRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBinanceRestClientApplication.class, args);
	}

}
