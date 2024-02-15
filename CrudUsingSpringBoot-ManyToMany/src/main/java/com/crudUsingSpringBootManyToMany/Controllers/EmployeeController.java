package com.crudUsingSpringBootManyToMany.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudUsingSpringBootManyToMany.Entity.Employee;
import com.crudUsingSpringBootManyToMany.Services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value= {"/getEmployees","/{empid}"})
	public List<Employee> getEmployee(@PathVariable (required = false) Long empid){
		return employeeService.getEmployeeDetails(empid);
	}
	
	@DeleteMapping("delete/{empid}")
	public ResponseEntity<?> removeEmployee(@PathVariable Long empid) {
		employeeService.deleteEmployee(empid);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PutMapping("/{empid}/project/{projectId}")
	public Employee assignProjectToEmployee(@PathVariable Long empid,@PathVariable Long projectId) {
		return employeeService.assignProjectToEmployee(empid, projectId);
	}
}
