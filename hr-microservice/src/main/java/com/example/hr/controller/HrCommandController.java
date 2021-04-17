package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrCommandService;
import com.example.validation.TcKimlikNo;

@RestController // Meta annotation
@RequestMapping("employees")
@RequestScope
@CrossOrigin
public class HrCommandController {
	@Autowired
	private HrCommandService hrCommandService;

	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody @Validated HireEmployeeRequest request) {
		return hrCommandService.hireEmployee(request);
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable @TcKimlikNo String identity) {
		return hrCommandService.fireEmployee(identity);
	}

}
