package com.example.stockmarket.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.stockmarket.document.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TradeRabbitMQService {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ObjectMapper mapper;

	@EventListener
	public void listenTrade(Trade trade) {
		try {
			rabbitTemplate.convertAndSend("stockmarket", null, mapper.writeValueAsString(trade));
		} catch (JsonProcessingException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
