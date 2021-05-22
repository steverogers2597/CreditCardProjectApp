package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.creditcard.entity.Customer;

import com.cg.creditcard.repository.CustomerRepository;
import com.cg.creditcard.service.ICustomerService;


@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		List<Customer> cList= customerRepository.findAll();
		return cList;
	}
	
	public Customer getCustomer(String custId) {
		Optional<Customer> optional = customerRepository.findById(custId);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.saveAndFlush(customer);
		
	}
	
	public void removeCustomer(String custId) {
		
		customerRepository.deleteById(custId);
		
	}
	
	public Customer updateCustomer(String custId,Customer customer) {
		Optional<Customer> optional = customerRepository.findById(custId);
		if(!optional.isPresent()) {
			
			return null;
		}
		customer=optional.get();
		return customerRepository.save(customer);
		
	}
	
}
