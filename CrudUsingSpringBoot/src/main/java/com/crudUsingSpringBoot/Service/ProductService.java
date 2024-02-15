package com.crudUsingSpringBoot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.crudUsingSpringBoot.Entity.Products;
import com.crudUsingSpringBoot.Repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	
	//for getting all products
	public List<Products> getAllProducts(){
		return productRepo.findAll();
	}
	
	//for Getting the product by id
	public Products getProductById(Long id) {
		Optional<Products>productOptional=productRepo.findById(id);
		return productOptional.orElse(null);
	}
	
	//For Posting The product
	public Products saveProducts (Products products) {
		return productRepo.save(products);
	}
	
	//For Deleting the product
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	
	//For Updating the Product
	public Products updateProducts(Products product,Long id) {
		Products productDB=productRepo.findById(id).get();
		
		if(Objects.nonNull(product.getName())&&!"".equalsIgnoreCase(product.getName())) {
			productDB.setName(product.getName());
		}
		if(Objects.nonNull(product.getPrice())&&product.getPrice()!=0) {
			productDB.setPrice(product.getPrice());
		}
		return productRepo.save(productDB);
	}
	
	//For Searching the product by name
	public List<Products> findProductByName(String name){
		return productRepo.findByName(name);
	}
	
	//For Searching the product by price
	public List<Products> findProductByPrice(int price){
		return productRepo.findByPrice(price);
	}
	
	//Find the product between particular price
//	public List<Products>findProductByPriceRange(double minPrice,double maxPrice){
//		return productRepo.findByPriceBetween(minPrice, maxPrice);
//	}
	
	//For Find the product between particular price
	public List<Products>findProductByPriceRange(int minPrice,int maxPrice){
		List<Products> product = new ArrayList<>();
        List<Products> prodretrieved = new ArrayList<>()  ;
        product = productRepo.findAll();
        
        for(int i=0 ; i<product.size() ; i++) {
        	if(minPrice < product.get(i).getPrice() && product.get(i).getPrice() < maxPrice) {
        		prodretrieved.add(product.get(i));
        	}
        }              
        return prodretrieved;
	}	
}
