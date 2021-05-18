package com.cg.creditcard.repository;

import org.springframework.stereotype.Repository;

import com.cg.creditcard.entity.CreditCard;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	
	

}
