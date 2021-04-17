package com.example.crm.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crm.entity.Identity;
import com.example.crm.event.CustomerBaseEvent;

public interface CustomerEventRepository extends MongoRepository<CustomerBaseEvent, String>{

	Optional<CustomerBaseEvent> findTopByIdentityNoOrderByDateDesc(Identity identity);

}
