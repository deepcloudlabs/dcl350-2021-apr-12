package com.example.stockmarket.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import com.example.stockmarket.document.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BinanceWebsocketClient implements WebSocketHandler {
	@Autowired
	private WebSocketClient websocketClient;
	@Value("${binance.ws.url}")
	private String binanceWsUrl;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostConstruct
	public void connect() {
		websocketClient.doHandshake(this, binanceWsUrl);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("Connected to the binance");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		Trade trade = objectMapper.readValue(message.getPayload().toString(),Trade.class);
		// Trade: event -> kafka, entity -> mongodb
		publisher.publishEvent(trade);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.err.println("Error: " + exception.getMessage());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.err.println("Disconnected from the binance");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
