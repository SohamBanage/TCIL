package com.crudUsingSpringBootOneToMany.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudUsingSpringBootOneToMany.Entity.Customer;
import com.crudUsingSpringBootOneToMany.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomerById(int id){
		return customerRepository.findById(id);
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer updateCustomer(int id,Customer customer) {
		customer.setId(id);
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
}
