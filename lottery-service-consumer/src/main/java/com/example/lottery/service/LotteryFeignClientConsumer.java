package com.example.lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LotteryFeignClientConsumer {

	@Autowired
	private LotteryService lotteryService;
	
	@Scheduled(fixedRate = 3_000)
	public void callLotteryService() {
		lotteryService.draw(5).getNumbers().forEach(System.err::println);
	}
}
