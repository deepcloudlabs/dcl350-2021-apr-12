package com.example.hr.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HrKafkaController {
	@Autowired
	private HrApplication hrApplication;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@EventListener
	public void listenEvent(String event) {
		
	}
	@KafkaListener(topics = "hr", groupId = "hr")
	public void listen(String request) throws Exception {
		var hireEmployeeRequest = objectMapper.readValue(request,HireEmployeeRequest.class);
		var employee = modelMapper.map(hireEmployeeRequest,Employee.class);
		var hiredEmployee = hrApplication.hireEmployee(employee);
		var hiredEmployeeResponse = modelMapper.map(hiredEmployee, HireEmployeeResponse.class);
		System.err.println("HrKafkaController::listen");
		kafkaTemplate.send("result", objectMapper.writeValueAsString(hiredEmployeeResponse));
	}
	
}
