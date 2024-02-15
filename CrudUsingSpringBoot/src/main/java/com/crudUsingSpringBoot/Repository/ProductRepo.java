package com.crudUsingSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudUsingSpringBoot.Entity.Products;

public interface ProductRepo extends JpaRepository<Products, Long>{

	List<Products> findByName(String name);
	
	List<Products> findByPrice(int price);
	
	List<Products> findByPriceBetween(int minPrice, int maxPrice);
}
