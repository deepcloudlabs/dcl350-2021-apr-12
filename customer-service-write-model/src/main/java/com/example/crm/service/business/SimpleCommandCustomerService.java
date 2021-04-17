package com.example.crm.service.business;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.entity.Identity;
import com.example.crm.event.CustomerBaseEvent;
import com.example.crm.event.CustomerCreatedEvent;
import com.example.crm.event.CustomerDeletedEvent;
import com.example.crm.event.CustomerPhotoChangedEvent;
import com.example.crm.repository.CustomerEventRepository;
import com.example.crm.service.CustomerCommandService;

@Service
public class SimpleCommandCustomerService implements CustomerCommandService {
	@Autowired
	private KafkaTemplate<String, CustomerBaseEvent> kafkaTemplate;
	@Autowired
	private CustomerEventRepository eventRepository;

	@Override
	public void createCustomer(Customer customer) {
		Optional<CustomerBaseEvent> latestEvent = eventRepository
				.findTopByIdentityNoOrderByDateDesc(customer.getIdentity());
		if (!latestEvent.isPresent() || latestEvent.get().getClass() == CustomerDeletedEvent.class) {
			CustomerCreatedEvent event = new CustomerCreatedEvent(customer);
			eventRepository.save(event);
			kafkaTemplate.send("events", event);
		}
	}

	@Override
	public void deleteByIdentity(String identityNo) {
		Optional<CustomerBaseEvent> latestEvent = eventRepository
				.findTopByIdentityNoOrderByDateDesc(new Identity(identityNo));
		latestEvent.ifPresent(event -> {
			CustomerDeletedEvent customerDeletedEvent = new CustomerDeletedEvent(identityNo);
			eventRepository.save(customerDeletedEvent);
			kafkaTemplate.send("events", customerDeletedEvent);
		});
	}

	@Override
	public void updateCustomer(Customer customer) {
		Optional<CustomerBaseEvent> latestEvent = eventRepository
				.findTopByIdentityNoOrderByDateDesc(customer.getIdentity());
		if (latestEvent.isPresent() && latestEvent.get().getClass() != CustomerDeletedEvent.class) {
			if (Objects.nonNull(customer.getPhoto())) {
				CustomerPhotoChangedEvent event = new CustomerPhotoChangedEvent(customer);
				eventRepository.save(event);
				kafkaTemplate.send("events", event);
			}
		}
	}

}
