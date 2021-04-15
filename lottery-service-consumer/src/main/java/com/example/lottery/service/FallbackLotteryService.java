package com.example.lottery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lottery.dto.LotteryResponse;

@Service
public class FallbackLotteryService  implements LotteryService {

	@Override
	public LotteryResponse draw(int column) {
		var lotteryResponse = new LotteryResponse();
		lotteryResponse.setNumbers(List.of(List.of(1,2,3,4,5,6),List.of(4,8,15,16,23,42)));
		return lotteryResponse;
	}

}
