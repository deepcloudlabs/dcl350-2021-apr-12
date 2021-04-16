package com.example.lottery.service;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LotteryConsumerService {
	@Autowired
	private LotteryService lotteryService;
	
	@Scheduled(fixedRate = 10_000)
	public void callLotteryService() {
		IntStream.range(0, 50)
		         .parallel()
		         .forEach( i -> System.err.println(lotteryService.getLotteryNumbers()));
	}
	
}
