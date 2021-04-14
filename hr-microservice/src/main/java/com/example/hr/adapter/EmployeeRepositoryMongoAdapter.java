package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;

@Service
@ConditionalOnProperty(name = "database.type", havingValue = "mongo")
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {

	@Autowired
	private EmployeeDocumentRepository repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Employee create(Employee employee) {
		var document = modelMapper.map(employee, EmployeeDocument.class);
		var savedDocument = repo.save(document);
		return modelMapper.map(savedDocument, Employee.class);
	}

	@Override
	public Optional<Employee> findByKimlikNo(TcKimlikNo kimlik) {
		var document = repo.findById(kimlik.getValue());
		if (document.isEmpty())
			return Optional.empty();
		return Optional.of(modelMapper.map(document.get(), Employee.class));
	}

	@Override
	public void remove(Employee employee) {
		var identity = employee.getTcKimlikNo().getValue();
		var document = repo.findById(identity);
		if (document.isPresent())
			repo.delete(document.get());
	}

}
