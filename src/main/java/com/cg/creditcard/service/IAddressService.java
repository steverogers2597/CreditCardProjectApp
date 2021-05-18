package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Address;
import com.cg.creditcard.model.AddressDTO;
import com.cg.creditcard.model.CustomerDTO;

public interface IAddressService {
	
	void addAddress(AddressDTO addressdto);
	void updateAddress(Integer addrId,AddressDTO addressdto);
	void removeAddress(Integer addrId);
	AddressDTO getAddress(Integer addrId);
	List<AddressDTO> getAllAddresses();
}
