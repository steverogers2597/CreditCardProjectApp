package com.cg.creditcard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.entity.Transaction;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{
	 
}
