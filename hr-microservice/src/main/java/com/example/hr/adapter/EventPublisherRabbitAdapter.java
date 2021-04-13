package com.example.hr.adapter;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@ConditionalOnProperty(name="event.publisher", havingValue = "rabbit")
public class EventPublisherRabbitAdapter implements EventPublisher {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	@Value("${exchange.name}")
	private String exchangeName;
	
	@Override
	public void publish(EmployeeEvent employeeEvent) {
		try {
			rabbitTemplate.convertAndSend(exchangeName, null, objectMapper.writeValueAsString(employeeEvent));
		} catch (AmqpException | JsonProcessingException e) {
			System.err.println("Error in sending/converting message: "+e.getMessage());
		}

	}

}
