package com.example.lottery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.dto.LotteryResponse;
import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("numbers")
@RequestScope
public class LotteryController {

	private LotteryService lotteryService;

	public LotteryController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	// http://localhost:5100/lottery/api/v1/numbers?column=10
	@GetMapping(params="column")
	public LotteryResponse getNumbers(@RequestParam(required = false,defaultValue = "3") int column){
		return lotteryService.draw(column);
	}
}
