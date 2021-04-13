package com.example.hr.event;

import com.example.hr.domain.TcKimlikNo;

public class EmployeeHiredEvent extends EmployeeEvent {

	public EmployeeHiredEvent(TcKimlikNo kimlik) {
		super(kimlik);
	}

}
