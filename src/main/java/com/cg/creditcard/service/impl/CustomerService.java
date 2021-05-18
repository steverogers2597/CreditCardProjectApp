package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.model.CustomerDTO;
import com.cg.creditcard.repository.CustomerRepository;
import com.cg.creditcard.service.ICustomerService;
import com.cg.creditcard.utils.CustomerUtils;

@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerDTO> getAllCustomers(){
		List<Customer> cList= customerRepository.findAll();
		List<CustomerDTO> dtoList = CustomerUtils.convertToCustomerDtoList(cList);
		return dtoList;
	}
	
	public CustomerDTO getCustomer(String custId) {
		CustomerDTO customerDto =new CustomerDTO();
		Optional<Customer> optional = customerRepository.findById(custId);
		if(optional.isPresent()) {
			Customer customer=optional.get();
			customerDto= CustomerUtils.convertToCustomerDto(customer);
		}
		return customerDto;
	}
	
	public void addCustomer(CustomerDTO customerdto) {
		
		customerRepository.saveAndFlush(CustomerUtils.convertToCustomer(customerdto));
		
	}
	
	public void removeCustomer(String custId) {
		
		customerRepository.deleteById(custId);
		
	}
	
	public void updateCustomer(String custId,CustomerDTO customerdto) {
		Optional<Customer> optional = customerRepository.findById(custId);
		if(optional.isPresent()) {
			Customer customer=optional.get();
			customerRepository.save(CustomerUtils.convertToCustomer(customerdto));
			
		}
		
	}
	
}
