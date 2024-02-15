package com.crudUsingSpringBootMapping.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long empid;
	private String empName;
	private Integer empAge;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_emp_id",referencedColumnName = "emp_id")
	private List<Address>address;

	public Employee(Long empid, String empName, Integer empAge, List<Address> address) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empAge = empAge;
		this.address = address;
	}

	public Employee() {
		super();
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
}
