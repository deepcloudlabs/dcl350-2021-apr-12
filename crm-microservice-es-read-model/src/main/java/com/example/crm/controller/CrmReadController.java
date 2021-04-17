package com.example.crm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crm.dto.CustomerResponse;
import com.example.crm.service.CustomerService;

@RestController
@RequestMapping("customers")
@RequestScope
public class CrmReadController {

	private CustomerService customerService;
	
	public CrmReadController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("{identity}")
	public CustomerResponse getCustomerByIdentity(@PathVariable String identity) {
		return customerService.findByIdentity(identity);
	}
	
	@GetMapping(params = {"page","size"})
	public List<CustomerResponse> getCustomersByPage(
			@RequestParam int page,@RequestParam int size) {
		return customerService.findAll(page,size);
	}	

}
