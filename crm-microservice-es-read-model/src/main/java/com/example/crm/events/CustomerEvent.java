package com.example.crm.events;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer-events")
public abstract class CustomerEvent {
	private String eventId;
	private String conversationId;
	private String identity;

	public CustomerEvent() {
	}

	public CustomerEvent(String eventId, String conversationId, String identity) {
		this.eventId = eventId;
		this.conversationId = conversationId;
		this.identity = identity;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
