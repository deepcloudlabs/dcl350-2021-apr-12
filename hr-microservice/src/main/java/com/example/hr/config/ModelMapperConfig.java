package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.EmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;

@Configuration
public class ModelMapperConfig {
	private static final Converter<HireEmployeeRequest,Employee> hireEmployeeRequest2EmployeeConverter =
			context -> {
				 var request = context.getSource();
				 return new Employee.Builder(TcKimlikNo.valueOf(request.getIdentity()))
						            .fullname(request.getFirstName(), request.getLastName())
						            .salary(request.getSalary(), request.getCurrency())
						            .iban(request.getIban())
						            .birthYear(request.getBirthYear())
						            .department(request.getDepartment().name())
						            .jobStyle(request.getJobStyle().name())
						            .photo(request.getPhoto())
						            .build();
			};
			
	private static final Converter<Employee, EmployeeResponse> employee2EmployeeResponseConverter =
			context -> {
				var employee = context.getSource();
				var response = new EmployeeResponse();
				response.setIdentity(employee.getTcKimlikNo().getValue());
				response.setIban(employee.getIban().getValue());
				response.setFirstName(employee.getFullName().getFirstName());
				response.setLastName(employee.getFullName().getLastName());
				response.setSalary(employee.getSalary().getValue());
				response.setCurrency(employee.getSalary().getCurrency());
				response.setBirthYear(employee.getBirthYear().getValue());
				response.setDepartment(employee.getDepartment());
				response.setJobStyle(employee.getJobStyle());
				return response;
			};
			
	private static final Converter<Employee, HireEmployeeResponse> employee2HireEmployeeResponseConverter =
			context -> {
				var employee = context.getSource();
				var response = new HireEmployeeResponse();
				response.setIdentity(employee.getTcKimlikNo().getValue());
				response.setIban(employee.getIban().getValue());
				response.setFirstName(employee.getFullName().getFirstName());
				response.setLastName(employee.getFullName().getLastName());
				response.setSalary(employee.getSalary().getValue());
				response.setCurrency(employee.getSalary().getCurrency());
				response.setBirthYear(employee.getBirthYear().getValue());
				response.setDepartment(employee.getDepartment());
				response.setJobStyle(employee.getJobStyle());
				return response;
			};
			
	@Bean
	public ModelMapper mapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(hireEmployeeRequest2EmployeeConverter, HireEmployeeRequest.class, Employee.class);
		modelMapper.addConverter(employee2EmployeeResponseConverter, Employee.class, EmployeeResponse.class);
		modelMapper.addConverter(employee2HireEmployeeResponseConverter, Employee.class, HireEmployeeResponse.class);
		return modelMapper;
	}
}
