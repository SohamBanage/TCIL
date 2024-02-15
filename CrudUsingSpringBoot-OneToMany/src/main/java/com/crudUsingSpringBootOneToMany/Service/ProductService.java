package com.crudUsingSpringBootOneToMany.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudUsingSpringBootOneToMany.Entity.Product;
import com.crudUsingSpringBootOneToMany.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllCustomer(){
		return productRepository.findAll();
	}
	
	public Optional<Product> getCustomerById(int id){
		return productRepository.findById(id);
	}
	
	public Product createCustomer(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateCustomer(int pid,Product product) {
		product.setPid(pid);
		return productRepository.save(product);
	}
	
	public void deleteCustomer(int id) {
		productRepository.deleteById(id);
	}
}
