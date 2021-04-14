package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "hr-events")
	public void listenEvents(String event) {
		System.err.println(event);
	}
}
