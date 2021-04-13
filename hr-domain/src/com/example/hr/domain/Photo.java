package com.example.hr.domain;

import java.util.Base64;
import java.util.Objects;

public final class Photo {
	private final byte[] data;

	private Photo(byte[] data) {
		this.data = data;
	}

	public byte[] getData() {
		return data;
	}

	static public Photo valueOf(byte[] data) {
		Objects.requireNonNull(data);
		return new Photo(data);
	}

	static public Photo valueOf(String data) {
		Objects.requireNonNull(data);
		return new Photo(Base64.getDecoder().decode(data));
	}
	
}
