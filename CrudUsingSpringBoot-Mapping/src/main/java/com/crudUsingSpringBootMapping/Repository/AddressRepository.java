package com.crudUsingSpringBootMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudUsingSpringBootMapping.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
