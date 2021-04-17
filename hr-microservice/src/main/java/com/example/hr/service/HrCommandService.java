package com.example.hr.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;

@Service
public class HrCommandService {
	// Command -> Event -> Write Model -> Entity
	@Autowired
	private HrApplication hrApplication;
	@Autowired
	private ModelMapper modelMapper;

	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		var employee = modelMapper.map(request, Employee.class);
		Employee hiredEmployee = hrApplication.hireEmployee(employee);
		return modelMapper.map(hiredEmployee, HireEmployeeResponse.class);
	}

	public FireEmployeeResponse fireEmployee(String identity) {
		var employee = hrApplication.fireEmployee(TcKimlikNo.valueOf(identity));
		if (employee.isPresent())
			return new FireEmployeeResponse("success");
		return new FireEmployeeResponse("failed");
	}

}
