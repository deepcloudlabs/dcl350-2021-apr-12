package com.example.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.document.CustomerDocument;
import com.example.crm.service.CustomerReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
public class CrmController {
	@Autowired
	private CustomerReactiveService customerReactiveService;

	@GetMapping(params = {"page","size"})
	public Flux<CustomerDocument> getCustomerByPage(@RequestParam int page,@RequestParam int size){
		return customerReactiveService.findCustomers(page,size);
	}
	
	@GetMapping("{email}")
	public Mono<CustomerDocument> getCustomerByEmail(@PathVariable String email){
		return customerReactiveService.findCustomerByEmail(email);
	}
	
	@PostMapping
	public Mono<CustomerDocument> addCustomer(@RequestBody CustomerDocument customer){
		return customerReactiveService.createCustomer(customer);
	}
	
	@PutMapping
	public Mono<CustomerDocument> updateCustomer(@RequestBody CustomerDocument customer){
		return customerReactiveService.updateCustomer(customer);
	}
	
	/*
	@DeleteMapping("{email}")
	public Mono<CustomerDocument> deleteCustomerByEmail(@PathVariable String email){
		return customerReactiveService.removeCustomerByEmail(email);
	}
	*/
	
}
