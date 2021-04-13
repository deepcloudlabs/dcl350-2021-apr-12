package com.example.hr.event;

import com.example.hr.domain.TcKimlikNo;

public class EmployeeFiredEvent extends EmployeeEvent {

	public EmployeeFiredEvent(TcKimlikNo kimlik) {
		super(kimlik);
	}

}
