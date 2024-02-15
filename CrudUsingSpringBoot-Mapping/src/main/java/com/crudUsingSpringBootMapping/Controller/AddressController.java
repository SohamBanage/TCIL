package com.crudUsingSpringBootMapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudUsingSpringBootMapping.Entity.Address;
import com.crudUsingSpringBootMapping.Repository.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/getAddress")
	public List<Address> getEmployees(){
		return addressRepository.findAll();
	}
}
