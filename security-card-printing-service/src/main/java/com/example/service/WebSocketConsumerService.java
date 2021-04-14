package com.example.service;

import java.lang.reflect.Type;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.example.dto.EmployeeEvent;


@Service
public class WebSocketConsumerService implements StompSessionHandler {
	@Autowired
	private WebSocketStompClient client;

	@PostConstruct
	public void connectToMarket() {
		client.connect("ws://localhost:4001/hr/api/v1/changes", this);
	}

	@Override
	public Type getPayloadType(StompHeaders stompHeaders) {
		return EmployeeEvent.class;
	}

	@Override
	public void handleFrame(StompHeaders header, Object payload) {
		var event = (EmployeeEvent) payload;
		System.err.println("Message received: " + event);
	}

	@Override
	public void afterConnected(StompSession session, StompHeaders headers) {
		System.err.println("Connected!");
		session.subscribe("/topic/changes", this);
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] arg3, Throwable error) {
		System.err.println(error);
	}

	@Override
	public void handleTransportError(StompSession session, Throwable error) {
		System.err.println(error);

	}
}
