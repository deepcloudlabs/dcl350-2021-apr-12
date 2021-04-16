package com.example.hr.adapter;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeEntity;
import com.example.hr.repository.EmployeeEntityRepository;
import com.example.hr.repository.EmployeeRepository;

@Repository
@ConditionalOnProperty(name="database.type", havingValue = "mysql")
public class EmployeeRepositoryJpaAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeEntityRepository repo;
	@Autowired
	private ModelMapper mapper;

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Transactional(isolation=Isolation.DEFAULT,propagation = Propagation.MANDATORY)
	public Employee create(Employee employee) {
		var entity = mapper.map(employee, EmployeeEntity.class);
		var managedEntity = repo.save(entity);
		return mapper.map(managedEntity, Employee.class);
	}

	@Override
	public Optional<Employee> findByKimlikNo(TcKimlikNo kimlik) {
		var entity = repo.findById(kimlik.getValue());
		if (entity.isEmpty())
			return Optional.empty();
		return Optional.of(mapper.map(entity.get(), Employee.class));
	}

	@Override
	@Transactional
	public void remove(Employee employee) {
		var identity = employee.getTcKimlikNo().getValue();
		var entity = repo.findById(identity);
		if (entity.isPresent()) {
			repo.delete(entity.get());
		}

	}

}
