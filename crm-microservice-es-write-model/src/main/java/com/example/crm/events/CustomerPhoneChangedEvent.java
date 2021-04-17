package com.example.crm.events;

import com.example.crm.domain.Phone;

public class CustomerPhoneChangedEvent extends CustomerEvent {
	private Phone phone;

	
	public CustomerPhoneChangedEvent() {
	}


	public CustomerPhoneChangedEvent(Phone phone) {
		this.phone = phone;
	}


	public CustomerPhoneChangedEvent(String eventId, String conversationId, String identity, Phone phone) {
		super(eventId, conversationId, identity);
		this.phone = phone;
	}


	public Phone getPhone() {
		return phone;
	}


	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
}
