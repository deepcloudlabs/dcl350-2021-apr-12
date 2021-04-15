package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.example.lottery.dto.LotteryResponse;
import com.example.lottery.service.LotteryService;

@Service
@RefreshScope
public class StandardLotteryService implements LotteryService {
	@Value("${lottery.max}")
	private int lotteryMax;
	@Value("${lottery.size}")
	private int lotterySize;
	@Value("${server.port}")
	private int serverPort;

	@Override
	public LotteryResponse draw(int column) {
		System.err.println("Lottery service is producing lottery numbers @ "+serverPort);
		var numbers = IntStream.range(0, column)
				        .mapToObj(i -> draw(lotteryMax,lotterySize))
				        .collect(Collectors.toList());
		return new LotteryResponse(numbers);
	}

	public List<Integer> draw(int max,int size){
		return ThreadLocalRandom.current().ints(1, max)
		    .distinct().limit(size).sorted().boxed().collect(Collectors.toList());
	}
}
