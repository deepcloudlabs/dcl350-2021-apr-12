package com.example.crm.document.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crm.document.CustomerDocument;

public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument, String>{

}
