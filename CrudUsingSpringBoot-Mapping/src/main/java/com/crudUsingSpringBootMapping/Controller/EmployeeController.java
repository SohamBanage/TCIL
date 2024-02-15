package com.crudUsingSpringBootMapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudUsingSpringBootMapping.Entity.Employee;
import com.crudUsingSpringBootMapping.Repository.EmployeeRepository;
import com.crudUsingSpringBootMapping.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
//	@PostMapping("/saveEmployees")
//	public ResponseEntity<String>saveEmployee(@RequestBody List<Employee>empData ){
//		employeeRepository.saveAll(empData);
//		return ResponseEntity.ok("Data save");
//	}
//	@GetMapping("/getall")
//	public List<Employee> getEmployee(){
//		return employeeRepository.findAll();
//	}
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<String>saveEmployee(@RequestBody List<Employee>empData ){
		employeeService.saveEmployee(empData);
		return ResponseEntity.ok("Data save");
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>>getEmployee(){
		List<Employee> employees = employeeService.getAllEmployee();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
}
