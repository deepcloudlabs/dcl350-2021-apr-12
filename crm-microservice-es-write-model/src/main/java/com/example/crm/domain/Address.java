package com.example.crm.domain;

public class Address {
	private final AddressType type;
	private final String country;
	private final String city;
	private final String street;
	private final String building;
	private final String zipCode;

	private Address(AddressType type, String country, String city, String street, String building, String zipCode) {
		this.type = type;
		this.country = country;
		this.city = city;
		this.street = street;
		this.building = building;
		this.zipCode = zipCode;
	}

	private Address(Builder builder) {
		this.type = builder.type;
		this.country = builder.country;
		this.city = builder.city;
		this.street = builder.street;
		this.building = builder.building;
		this.zipCode = builder.zipCode;
	}

	public AddressType getType() {
		return type;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getBuilding() {
		return building;
	}

	public String getZipCode() {
		return zipCode;
	}

	public static class Builder {
		private AddressType type;
		private String country;
		private String city;
		private String street;
		private String building;
		private String zipCode;

		public Builder type(AddressType type) {
			this.type = type;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		public Builder street(String street) {
			this.street = street;
			return this;
		}

		public Builder building(String building) {
			this.building = building;
			return this;
		}

		public Builder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
	}
}
