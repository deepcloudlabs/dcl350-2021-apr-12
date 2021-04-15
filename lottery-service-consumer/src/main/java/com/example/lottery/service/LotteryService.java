package com.example.lottery.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lottery.dto.LotteryResponse;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@FeignClient(name = "lottery-producer")
public interface LotteryService {

	@GetMapping("/lottery/api/v1/numbers")
	@Bulkhead(name = "lottery", fallbackMethod = "drawFallBack")
	LotteryResponse draw(@RequestParam int column);

	default public LotteryResponse drawFallBack(int column, Exception e) {
		var lotteryResponse = new LotteryResponse();
		lotteryResponse.setNumbers(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(4, 8, 15, 16, 23, 42)));
		return lotteryResponse;
	}
}
