package com.example.crm.domain;

import java.util.List;

public class Customer {
	private TcKimlikNo identity;
	private FullName fullname;
	private Email email;
	private BirthYear birthYear;
	private List<Phone> phones;
	private List<Address> addresses;
	private Photo photo;

	public TcKimlikNo getIdentity() {
		return identity;
	}

	public void setIdentity(TcKimlikNo identity) {
		this.identity = identity;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(BirthYear birthYear) {
		this.birthYear = birthYear;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}
