package com.crudUsingSpringBootOneToMany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudUsingSpringBootOneToMany.Entity.Customer;
import com.crudUsingSpringBootOneToMany.Entity.Product;
import com.crudUsingSpringBootOneToMany.Service.CustomerProductsService;

@RestController

public class CustomerProductsController {

	@Autowired
	public CustomerProductsService customerProductsService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String>saveCustomer(@RequestBody List<Customer>custData){
		customerProductsService.saveCustomer(custData);
		return ResponseEntity.ok("DAta save");
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>>getCustomer(){
		List<Customer> customer = customerProductsService.getAllCustomer();
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	
}
