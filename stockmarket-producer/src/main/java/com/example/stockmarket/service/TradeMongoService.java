package com.example.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.stockmarket.document.Trade;
import com.example.stockmarket.repository.TradeRepository;

@Service
public class TradeMongoService {
	@Autowired
	private TradeRepository tradeRepository;

	@EventListener
	public void listenTrade(Trade trade) {
		tradeRepository.save(trade);
	}
}
