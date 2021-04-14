package com.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumerService {

	@RabbitListener(queues = "hrqueue")
	public void listenEvents(String event) {
		System.err.println("Rabbit: "+event);
	}
}
