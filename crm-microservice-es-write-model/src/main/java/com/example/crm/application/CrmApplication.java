package com.example.crm.application;

import com.example.crm.document.repository.CustomerEventRepository;
import com.example.crm.domain.Customer;
import com.example.crm.events.CustomerAcquiredEvent;
import com.example.crm.events.CustomerAddressChangedEvent;
import com.example.crm.events.CustomerEmailChangedEvent;
import com.example.crm.events.CustomerEvent;
import com.example.crm.events.CustomerPhoneChangedEvent;
import com.example.crm.infrastructure.EventPublisher;

public class CrmApplication {
	private CustomerEventRepository customerEventRepository;
	private EventPublisher<CustomerEvent> eventPublisher;

	public CrmApplication(CustomerEventRepository customerEventRepository) {
		this.customerEventRepository = customerEventRepository;
	}

	public void acquireCustomer(Customer customer) {
		var event = new CustomerAcquiredEvent();
		customerEventRepository.save(event);
		eventPublisher.publishEvent(event);
	}

	public void changeCustomerAddress(Customer customer) {
		// check invariants
		// apply business rules
		var event = new CustomerAddressChangedEvent();
		customerEventRepository.save(event);
		eventPublisher.publishEvent(event);
	}

	public void changeCustomerPhone(Customer customer) {
		// check invariants
		// apply business rules
		var event = new CustomerPhoneChangedEvent();
		customerEventRepository.save(event);
		eventPublisher.publishEvent(event);
	}

	public void changeCustomerEmail(Customer customer) {
		// check invariants
		// apply business rules
		var event = new CustomerEmailChangedEvent();
		customerEventRepository.save(event);
		eventPublisher.publishEvent(event);
	}
}
