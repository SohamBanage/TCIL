package com.crudUsingSpringBootOneToMany.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudUsingSpringBootOneToMany.Entity.Customer;
import com.crudUsingSpringBootOneToMany.Entity.Product;
import com.crudUsingSpringBootOneToMany.Repository.CustomerRepository;
import com.crudUsingSpringBootOneToMany.Repository.ProductRepository;




@Service
public class CustomerProductsService {

	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public ProductRepository productRepository;
	
	
	public void saveCustomer(List<Customer>custData) {
		customerRepository.saveAll(custData);
	}
	public List<Customer>getAllCustomer(){
		return customerRepository.findAll();
	}
	
}
