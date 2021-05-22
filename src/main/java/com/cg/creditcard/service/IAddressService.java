package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Address;


public interface IAddressService {
	
	Address addAddress(Address addressdto);
	Address updateAddress(Integer addrId,Address addressdto);
	void removeAddress(Integer addrId);
	Address getAddress(Integer addrId);
	List<Address> getAllAddresses();
}
