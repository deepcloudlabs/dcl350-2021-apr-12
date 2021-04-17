package com.example.crm.event;

import java.util.Date;

public class CustomerDeletedEvent extends CustomerBaseEvent {

	public CustomerDeletedEvent() {
	}

	public CustomerDeletedEvent(String eventId, String identityNo, Date date) {
		super(eventId, identityNo, date);
	}

}
