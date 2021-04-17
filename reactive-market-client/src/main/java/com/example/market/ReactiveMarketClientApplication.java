package com.example.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReactiveMarketClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMarketClientApplication.class, args);
	}

}
