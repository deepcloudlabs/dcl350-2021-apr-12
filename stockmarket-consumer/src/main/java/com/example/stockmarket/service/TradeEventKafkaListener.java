package com.example.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeEventKafkaListener {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@KafkaListener(topics = "trades", groupId = "stockmarket")
	public void listenTrade(String trade) {
		simpMessagingTemplate.convertAndSend("/topic/changes", trade);
	}
}
