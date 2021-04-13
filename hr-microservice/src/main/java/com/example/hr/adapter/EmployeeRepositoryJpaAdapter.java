package com.example.hr.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryJpaAdapter implements EmployeeRepository {

	@Override
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findByKimlikNo(TcKimlikNo kimlik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Employee employee) {
		// TODO Auto-generated method stub

	}

}
