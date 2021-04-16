package com.example.hr.service;

import java.util.concurrent.CyclicBarrier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.hr.dto.HireEmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

//-Dspring.profiles.active=test
@Service
@Profile("test")
public class HireEmployeeResultKafkaListener {
	private CyclicBarrier barrier = new CyclicBarrier(2);
	@Autowired
	private ObjectMapper objectMapper;
	private HireEmployeeResponse response;

	@KafkaListener(topics = "result", groupId = "hr")
	public void listen(String result) throws Exception {
		response = objectMapper.readValue(result,HireEmployeeResponse.class);
		barrier.await();
	}

	public final HireEmployeeResponse getResponse() {
		return response;
	}

	public final CyclicBarrier getBarrier() {
		return barrier;
	}
	
	
}
