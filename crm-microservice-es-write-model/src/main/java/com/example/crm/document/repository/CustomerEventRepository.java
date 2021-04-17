package com.example.crm.document.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crm.events.CustomerEvent;

public interface CustomerEventRepository extends MongoRepository<CustomerEvent, String>{

}
