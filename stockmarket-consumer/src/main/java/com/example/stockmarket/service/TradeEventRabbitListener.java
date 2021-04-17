package com.example.stockmarket.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeEventRabbitListener {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@RabbitListener(queues="trades")
	public void listenTrade(@Payload String trade) {
		simpMessagingTemplate.convertAndSend("/topic/changes", trade);
	}
}
