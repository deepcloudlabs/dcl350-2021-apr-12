package com.example.crm.document;

import com.example.crm.domain.AddressType;

public class AddressDocument {
	private AddressType type;
	private String country;
	private String city;
	private String street;
	private String building;
	private String zipCode;

	public AddressDocument() {
	}

	public AddressDocument(AddressType type, String country, String city, String street, String building,
			String zipCode) {
		this.type = type;
		this.country = country;
		this.city = city;
		this.street = street;
		this.building = building;
		this.zipCode = zipCode;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
