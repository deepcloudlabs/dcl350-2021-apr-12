package com.example.crm.domain;

import java.util.Objects;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public final class Photo {
	private final byte[] values;

	private Photo(byte[] values) {
		this.values = values;
	}

	public byte[] getValues() {
		return values;
	}

	public static Photo valueOf(byte[] values) {
		Objects.requireNonNull(values);
		return new Photo(values);
	} 
}
