package com.example.crm.domain;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// Value Object -> Immutable Class -> record (since Java 14)
public class FullName {
	private final String first;
	private final String last;

	public FullName(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	@Override
	public String toString() {
		return first + " " + last;
	}
}

/*
 public record FullName (String first, String last) {}
  */
