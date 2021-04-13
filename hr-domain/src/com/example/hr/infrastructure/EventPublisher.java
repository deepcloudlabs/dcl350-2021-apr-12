package com.example.hr.infrastructure;

import com.example.hr.event.EmployeeEvent;

public interface EventPublisher {

	void publish(EmployeeEvent employeeEvent);

}
