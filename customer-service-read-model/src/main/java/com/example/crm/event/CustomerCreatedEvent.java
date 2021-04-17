package com.example.crm.event;

import java.util.Date;

import com.example.crm.entity.Customer;

public class CustomerCreatedEvent extends CustomerBaseEvent {
	private Customer customer;

	public CustomerCreatedEvent() {
	}

	public CustomerCreatedEvent(String eventId, String identityNo, Date date, Customer customer) {
		super(eventId, identityNo, date);
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerCreatedEvent [customer=" + customer + ", getEventId()=" + getEventId() + ", getIdentityNo()="
				+ getIdentityNo() + ", getDate()=" + getDate() + "]";
	}

}
