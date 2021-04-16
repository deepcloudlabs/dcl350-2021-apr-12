package com.example.lottery.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class LotteryService {
	
	private String cache="{\"numbers\":[[16,32,33,46,50,54],[4,24,32,33,35,46],[23,26,30,34,50,54],[10,27,35,36,38,43],[2,10,21,26,43,51]]}\r\n" + 
			"";

	@Retry(name = "lottery", fallbackMethod = "getLotteryNumbersFallback")
	@RateLimiter(name = "lottery", fallbackMethod = "getLotteryNumbersFallback" )
	@CircuitBreaker(name = "lottery", fallbackMethod = "getLotteryNumbersFallback")
	public String getLotteryNumbers() {
		RestTemplate restTemplate = new RestTemplate();
		cache = restTemplate.getForEntity("http://localhost:6100/lottery/api/v1/numbers?column=5", String.class).getBody();
		return cache;
	}
	
	public String getLotteryNumbersFallback(Exception e) {
		return cache;
	}
}
