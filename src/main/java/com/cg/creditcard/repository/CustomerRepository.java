package com.cg.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.creditcard.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{
	
}
