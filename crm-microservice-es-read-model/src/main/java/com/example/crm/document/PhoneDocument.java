package com.example.crm.document;

import com.example.crm.domain.PhoneType;

public class PhoneDocument {
	PhoneType type;
	String number;

	public PhoneDocument() {
	}

	public PhoneDocument(PhoneType type, String number) {
		this.type = type;
		this.number = number;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneDocument [type=" + type + ", number=" + number + "]";
	}

}
