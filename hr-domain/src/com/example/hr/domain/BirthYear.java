package com.example.hr.domain;

import com.example.hr.ddd.ValueObject;

@ValueObject
public final class BirthYear {
	private final int value;

	private BirthYear(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static BirthYear of(int value) {
		if (value > 2008)
			throw new IllegalArgumentException("Birth Year must be less than 2008");
		return new BirthYear(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirthYear other = (BirthYear) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BirthYear [value=" + value + "]";
	}

}
