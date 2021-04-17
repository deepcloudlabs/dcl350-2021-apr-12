package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.EmployeeResponse;
import com.example.hr.service.HrQueryService;
import com.example.validation.TcKimlikNo;

@RestController 
@RequestMapping("employees")
@RequestScope
@CrossOrigin
public class HrQueryController {
	@Autowired
	private HrQueryService hrQueryService;

	@GetMapping("{identity}")
	public EmployeeResponse getEmployee(@PathVariable @TcKimlikNo String identity) {
		return hrQueryService.getEmployee(identity);
	}

	@GetMapping("{identity}/photo")
	public String getEmployeePhoto(@PathVariable @TcKimlikNo String identity) {
		return hrQueryService.getEmployeePhoto(identity);
	}
}
