package com.example.crm.event;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class CustomerBaseEvent {
	private String eventId;
	private String identityNo;
	private Date date;

	public CustomerBaseEvent() {
	}

	public CustomerBaseEvent(String identityNo) {
		this(UUID.randomUUID().toString(), identityNo, new Date());
	}

	public CustomerBaseEvent(String eventId, String identityNo, Date date) {
		this.eventId = eventId;
		this.identityNo = identityNo;
		this.date = date;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomerBaseEvent [eventId=" + eventId + ", identityNo=" + identityNo + ", date=" + date + "]";
	}

}
