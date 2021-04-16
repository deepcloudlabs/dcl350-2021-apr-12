package com.example.crm.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.document.CustomerDocument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerDocumentRespository extends ReactiveMongoRepository<CustomerDocument, String>{

	Mono<CustomerDocument> findByEmail(String email);
	Flux<CustomerDocument> findByFullName(String fullName);
	@Query("{}")
	Flux<CustomerDocument> findAll(PageRequest page);
	
}
