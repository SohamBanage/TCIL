package com.crudUsingSpringBootManyToMany.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empid;
	
	private String empName;
	
	@ManyToMany
	@JoinTable(name = "employee_project",joinColumns = @JoinColumn(name="employee_id"),inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Project> assigProjects=new HashSet<>();

	public Employee(Long empid, String empName, Set<Project> assigProjects) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.assigProjects = assigProjects;
	}

	public Employee() {
		super();
	}

	public Long getEmp_id() {
		return empid;
	}

	public void setEmp_id(Long empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Set<Project> getAssigProjects() {
		return assigProjects;
	}

	public void setAssigProjects(Set<Project> assigProjects) {
		this.assigProjects = assigProjects;
	}
}
