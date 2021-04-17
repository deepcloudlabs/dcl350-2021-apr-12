package com.example.hr.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.EmployeeResponse;

@Service
public class HrQueryService {
	@Autowired
	ApplicationEventPublisher publisher;
	// Query -> Read Model* (Event (TxId, ConversationId)) -> Entity (Snapshot)
	//          
	@Autowired
	private HrApplication hrApplication;
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeResponse getEmployee(String identity) {
		publisher.publishEvent(identity);
		var employee = hrApplication.getEmployeeInformation(TcKimlikNo.valueOf(identity));
		if (employee.isPresent())
			return modelMapper.map(employee.get(), EmployeeResponse.class);
		throw new IllegalArgumentException("Cannot find employee");
	}

	public String getEmployeePhoto(String identity) {
		var employee = hrApplication.getEmployeeInformation(TcKimlikNo.valueOf(identity));
		if (employee.isPresent())
			return new String(employee.get().getPhoto().getData());
		throw new IllegalArgumentException("Cannot find employee");
	}
}
