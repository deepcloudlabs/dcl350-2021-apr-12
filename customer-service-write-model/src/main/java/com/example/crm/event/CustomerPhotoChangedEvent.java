package com.example.crm.event;

import java.util.Date;

import com.example.crm.entity.Customer;

public class CustomerPhotoChangedEvent extends CustomerBaseEvent {
	private String photo;

	public CustomerPhotoChangedEvent() {
	}

	public CustomerPhotoChangedEvent(Customer customer) {
		this(customer.getIdentity().getNo(), customer.getPhoto());
	}

	public CustomerPhotoChangedEvent(String identityNo, String photo) {
		super(identityNo);
		this.photo = photo;
	}

	public CustomerPhotoChangedEvent(String eventId, String identityNo, Date date, String photo) {
		super(eventId, identityNo, date);
		this.photo = photo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "CustomerPhotoChangedEvent [getEventId()=" + getEventId() + ", getIdentityNo()=" + getIdentityNo()
				+ ", getDate()=" + getDate() + "]";
	}

}
