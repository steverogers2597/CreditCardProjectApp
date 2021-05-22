package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Customer;


public interface ICustomerService{
	Customer addCustomer(Customer customer);
	void removeCustomer(String custId);
	Customer updateCustomer(String custId,Customer customer);
	Customer getCustomer(String custId);
	List<Customer> getAllCustomers();
}
