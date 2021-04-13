package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.EmployeeResponse;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrService;

@RestController
@RequestMapping("employees")
@RequestScope
@CrossOrigin
public class HrController { // Adapter: Http Protocol -> Java Class
	@Autowired
	private HrService hrService;
	
	@PostMapping("{identity}")
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		return hrService.hireEmployee(request);
	}

	// DELETE /hr/api/v1/employees/11111111110
	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable String identity) {
		return hrService.fireEmployee(identity);
	}
	
	@GetMapping("{identity}")
	public EmployeeResponse getEmployee(@PathVariable String identity) {
		return hrService.getEmployee(identity);
	}

	@GetMapping("{identity}/photo")
	public String getEmployeePhoto(@PathVariable String identity) {
		return hrService.getEmployeePhoto(identity);
	}
	
}
