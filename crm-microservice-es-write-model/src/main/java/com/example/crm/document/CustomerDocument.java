package com.example.crm.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class CustomerDocument {
	private String identity;
	private String fullname;
	private String email;
	private int birthYear;
	private List<PhoneDocument> phones;
	private List<AddressDocument> addresses;
	private String photo;

	public CustomerDocument() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public List<PhoneDocument> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDocument> phones) {
		this.phones = phones;
	}

	public List<AddressDocument> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDocument> addresses) {
		this.addresses = addresses;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "CustomerDocument [identity=" + identity + ", fullname=" + fullname + ", email=" + email + ", birthYear="
				+ birthYear + ", phones=" + phones + ", addresses=" + addresses + "]";
	}

}
