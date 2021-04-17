package com.example.crm.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.crm.events.CustomerEvent;
import com.example.crm.infrastructure.EventPublisher;

@Service
public class EventPublisherKafkaAdapter implements EventPublisher<CustomerEvent> {

	@Autowired
	private KafkaTemplate<String, CustomerEvent> kafkaTemplate;
	
	@Override
	public void publishEvent(CustomerEvent event) {
		kafkaTemplate.send("customer-events", event);
	}

}
