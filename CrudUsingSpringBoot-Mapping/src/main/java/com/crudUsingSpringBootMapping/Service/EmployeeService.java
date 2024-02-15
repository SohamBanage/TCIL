package com.crudUsingSpringBootMapping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudUsingSpringBootMapping.Entity.Employee;
import com.crudUsingSpringBootMapping.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveEmployee (List<Employee>empData) {
		 employeeRepository.saveAll(empData);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
}
