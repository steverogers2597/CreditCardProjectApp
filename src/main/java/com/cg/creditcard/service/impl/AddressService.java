package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.creditcard.entity.Address;


import com.cg.creditcard.repository.AddressRepository;
import com.cg.creditcard.service.IAddressService;



@Service
public class AddressService implements IAddressService{
	@Autowired
	AddressRepository addressRepository;
	
	public List<Address> getAllAddresses(){
		List<Address> aList= addressRepository.findAll();
		
		return aList;
	}
	
	public Address getAddress(Integer addrId) {
		Optional<Address> optional = addressRepository.findById(addrId);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public Address addAddress(Address address) {
		
		return addressRepository.saveAndFlush(address);
		
	}
	
	public void  removeAddress(Integer addrId) {
		
		addressRepository.deleteById(addrId);
		
	}
	
	public Address updateAddress(Integer addrId,Address address) {
		Optional<Address> optional = addressRepository.findById(addrId);
		if(!optional.isPresent()) {
			
			return null;
		}
		address=optional.get();
		return addressRepository.save(address);
	}
}
