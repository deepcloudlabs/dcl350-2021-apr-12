package com.example.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.stockmarket.document.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TradeKafkaService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper mapper;
	@EventListener
	public void listenTrade(Trade trade) {
		try {
			kafkaTemplate.send("trades", mapper.writeValueAsString(trade));
		} catch (JsonProcessingException e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
}
