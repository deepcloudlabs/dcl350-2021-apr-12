package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LotteryResilientConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryResilientConsumerApplication.class, args);
	}

}
