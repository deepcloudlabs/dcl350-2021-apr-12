package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@ConditionalOnProperty(name="event.publisher", havingValue = "kafka")
public class EventPublisherKafkaAdapter implements EventPublisher {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public void publish(EmployeeEvent employeeEvent) {
		try {
			kafkaTemplate.send("hr-events", mapper.writeValueAsString(employeeEvent));
		} catch (JsonProcessingException e) {
			System.err.println("Error in json conversion: "+e.getMessage());
		}		

	}

}
