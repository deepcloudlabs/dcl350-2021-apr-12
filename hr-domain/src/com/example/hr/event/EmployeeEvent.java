package com.example.hr.event;

import com.example.hr.ddd.BusinessEvent;
import com.example.hr.domain.TcKimlikNo;

@BusinessEvent
public abstract class EmployeeEvent {
	private TcKimlikNo kimlik;

	public EmployeeEvent(TcKimlikNo kimlik) {
		this.kimlik = kimlik;
	}

	public TcKimlikNo getKimlik() {
		return kimlik;
	}

	@Override
	public String toString() {
		return "EmployeeEvent [kimlik=" + kimlik + "]";
	}

}
