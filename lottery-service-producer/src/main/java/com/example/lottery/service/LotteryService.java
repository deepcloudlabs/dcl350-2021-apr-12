package com.example.lottery.service;

import com.example.lottery.dto.LotteryResponse;

public interface LotteryService {

	LotteryResponse draw(int column);

}
