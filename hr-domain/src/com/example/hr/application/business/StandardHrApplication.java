package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.event.EmployeeFiredEvent;
import com.example.hr.event.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private EmployeeRepository employeeRepository;
	private EventPublisher eventPublisher;

	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		var kimlik = employee.getTcKimlikNo();
		Employee managed = employeeRepository.create(employee);
		eventPublisher.publish(new EmployeeHiredEvent(kimlik));
		return managed;
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo kimlik) {
		var employee = employeeRepository.findByKimlikNo(kimlik);
		if (employee.isEmpty())
			throw new IllegalArgumentException("Cannot find employee");
		employeeRepository.remove(employee.get());
		eventPublisher.publish(new EmployeeFiredEvent(kimlik));
		return employee;
	}

	@Override
	public Optional<Employee> getEmployeeInformation(TcKimlikNo kimlik) {
		return employeeRepository.findByKimlikNo(kimlik);
	}

}
