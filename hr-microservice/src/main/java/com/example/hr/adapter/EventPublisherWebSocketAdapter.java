package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

@Service
@ConditionalOnProperty(name="event.publisher", havingValue = "websocket")
public class EventPublisherWebSocketAdapter implements EventPublisher {
	@Autowired
	private SimpMessagingTemplate smt;
	
	@Override
	public void publish(EmployeeEvent employeeEvent) {
		smt.convertAndSend("/topic/changes", employeeEvent);
	}

}
