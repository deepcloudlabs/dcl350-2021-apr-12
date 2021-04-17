package com.example.crm.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crm.dto.AddCustomerRequest;
import com.example.crm.dto.AddCustomerResponse;
import com.example.crm.dto.DeleteCustomerResponse;
import com.example.crm.dto.PatchCustomerResponse;
import com.example.crm.dto.UpdateCustomerRequest;
import com.example.crm.dto.UpdateCustomerResponse;

@RestController
@RequestMapping("customers")
@RequestScope
public class CrmWriteController {

	@PostMapping
	public AddCustomerResponse addCustomer(@RequestBody AddCustomerRequest request) {
		return null;
	}
	
	@PutMapping("{identity}")
	public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) {
		return null;		
	}
	
	@PatchMapping("{identity}")
	public PatchCustomerResponse patchCustomer(@RequestBody Map<String,Object> request) {
		return null;		
	}
	
	@DeleteMapping("{identity}")
	public DeleteCustomerResponse removeCustomer(@PathVariable String identity) {
		return null;				
	}
}
