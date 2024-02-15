package com.crudUsingSpringBootMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudUsingSpringBootMapping.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
