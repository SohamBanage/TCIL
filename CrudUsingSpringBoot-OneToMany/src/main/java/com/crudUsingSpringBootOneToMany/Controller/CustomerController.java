package com.crudUsingSpringBootOneToMany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudUsingSpringBootOneToMany.Entity.Customer;
import com.crudUsingSpringBootOneToMany.Service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	public CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>>getAllCustomers(){
		List<Customer> customer =customerService.getAllCustomer();
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer createCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(createCustomer,HttpStatus.OK);
	}
}
