package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

public interface EmployeeRepository {

	Employee create(Employee employee);

	Optional<Employee> findByKimlikNo(TcKimlikNo kimlik);

	void remove(Employee employee);

}
