package com.cg.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.entity.Payment;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Long>{

}
