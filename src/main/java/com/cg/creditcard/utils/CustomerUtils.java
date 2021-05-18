package com.cg.creditcard.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.model.CustomerDTO;

public class CustomerUtils {
	
	public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list){
		List<CustomerDTO> dtoList=new ArrayList<CustomerDTO>();
		for(Customer customer : list) {
			dtoList.add(convertToCustomerDto(customer));
		}
		return dtoList;
	}

	public static CustomerDTO convertToCustomerDto(Customer customer) {
		CustomerDTO customerDto =new CustomerDTO();
		customerDto.setUserId(customer.getUserId());
		customerDto.setName(customer.getName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setContactNo(customer.getContactNo());
		customerDto.setDob(customer.getDob());
		return customerDto;
	}
	
	public static Customer convertToCustomer(CustomerDTO customerDto) {
		Customer customer = new Customer();
		customer.setUserId(customerDto.getUserId());
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setContactNo(customerDto.getContactNo());
		customer.setDob(customerDto.getDob());
		return customer;
	}
	
}
