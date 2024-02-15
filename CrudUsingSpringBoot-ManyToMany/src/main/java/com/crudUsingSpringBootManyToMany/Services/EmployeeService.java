package com.crudUsingSpringBootManyToMany.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudUsingSpringBootManyToMany.Entity.Employee;
import com.crudUsingSpringBootManyToMany.Entity.Project;
import com.crudUsingSpringBootManyToMany.Repository.EmployeeRepository;
import com.crudUsingSpringBootManyToMany.Repository.ProjectReository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectReository projectReository;
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployeeDetails(Long empid){
		if(null != empid) {
			return employeeRepository.findAllByEmpid(empid);
		}else {
			return employeeRepository.findAll();
		}
	}
	
	public void deleteEmployee(Long empid) {
		employeeRepository.deleteById(empid);
	}
	
	public Employee assignProjectToEmployee(Long empid,Long projectId) {
		Set<Project> projectSet=null;
		Employee employee = employeeRepository.findById(empid).get();
		Project project = projectReository.findById(projectId).get();
		projectSet = employee.getAssigProjects();
		projectSet.add(project);
		employee.setAssigProjects(projectSet);
		return employeeRepository.save(employee);
	}
}
