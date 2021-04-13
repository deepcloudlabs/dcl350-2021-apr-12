package com.example.hr.domain;

import com.example.hr.ddd.ValueObject;

@ValueObject
public enum JobStyle {
	FULL_TIME(100), PART_TIME(200);
	private final int id;

	private JobStyle(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
