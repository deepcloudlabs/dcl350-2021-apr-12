package com.example.crm.domain;

import java.util.Objects;

public class Phone {
	private final String value;
	private final PhoneType type;

	private Phone(String value, PhoneType type) {
		this.value = value;
		this.type = type;
	}

	public static Phone valueOf(String value, PhoneType type) {
		Objects.requireNonNull(value);
		Objects.requireNonNull(type);
		return new Phone(value,type);
	}

	public String getValue() {
		return value;
	}

	public PhoneType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Phone [value=" + value + ", type=" + type + "]";
	}
	
}
