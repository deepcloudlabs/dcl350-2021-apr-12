package com.example.crm.service.business;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.entity.Identity;
import com.example.crm.event.CustomerCreatedEvent;
import com.example.crm.event.CustomerDeletedEvent;
import com.example.crm.event.CustomerPhotoChangedEvent;
import com.example.crm.repository.CustomerRepository;

@Service
public class CustomerEventConsumerService {
	@Autowired
	private CustomerRepository customerRepository;

	@KafkaListener(topics = "events")
	public void readCustomerCreatedEvent(CustomerCreatedEvent event) {
		customerRepository.save(event.getCustomer());
	}

	@KafkaListener(topics = "events")
	public void readCustomerDeletedEvent(CustomerDeletedEvent event) {
		customerRepository.deleteById(new Identity(event.getIdentityNo()));
	}
	
	@KafkaListener(topics = "events")
	public void readCustomerPhotoChangedEvent(CustomerPhotoChangedEvent event) {
		Consumer<Customer> updatePhoto = consumer -> consumer.setPhoto(event.getPhoto());
		Consumer<Customer> saveCustomer = customerRepository::save;
		customerRepository.findById(new Identity(event.getEventId()))
		                  .ifPresent(updatePhoto.andThen(saveCustomer));
	}
}
