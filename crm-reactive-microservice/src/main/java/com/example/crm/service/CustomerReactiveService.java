package com.example.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.document.CustomerDocument;
import com.example.crm.repository.CustomerDocumentRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerReactiveService {

	@Autowired
	private CustomerDocumentRespository customerRepo;
	
	public Flux<CustomerDocument> findCustomers(int page, int size) {
		return customerRepo.findAll(PageRequest.of(page, size));
	}

	public Mono<CustomerDocument> findCustomerByEmail(String email) {
		return customerRepo.findByEmail(email);
	}


	public Mono<CustomerDocument> createCustomer(CustomerDocument customer) {
		return customerRepo.save(customer);
	}

	public Mono<CustomerDocument> updateCustomer(CustomerDocument customer) {
		return customerRepo.save(customer);
	}

	public Mono<CustomerDocument> removeCustomerByEmail(String email) {
		return customerRepo.findByEmail(email)
				           .doOnNext(customerRepo::delete);
	}

}
