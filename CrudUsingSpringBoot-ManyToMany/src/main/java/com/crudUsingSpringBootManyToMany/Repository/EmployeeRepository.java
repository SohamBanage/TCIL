package com.crudUsingSpringBootManyToMany.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudUsingSpringBootManyToMany.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//List<Employee>findAllByEmpId(Long empid);
	List<Employee> findAllByEmpid(Long empid);
}
