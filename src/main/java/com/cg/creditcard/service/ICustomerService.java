package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.model.CustomerDTO;

public interface ICustomerService{
	void addCustomer(CustomerDTO customerdto);
	void removeCustomer(String custId);
	void updateCustomer(String custId,CustomerDTO customerdto);
	CustomerDTO getCustomer(String custId);
	List<CustomerDTO> getAllCustomers();
}
