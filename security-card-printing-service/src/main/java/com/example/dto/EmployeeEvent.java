package com.example.dto;

public class EmployeeEvent {
	private TcKimlikNo kimlik;

	public TcKimlikNo getKimlik() {
		return kimlik;
	}

	public void setKimlik(TcKimlikNo kimlik) {
		this.kimlik = kimlik;
	}

	@Override
	public String toString() {
		return "EmployeeEvent [kimlik=" + kimlik + "]";
	}

}
