package com.cg.creditcard.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.creditcard.entity.Address;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.model.AddressDTO;
import com.cg.creditcard.model.CustomerDTO;

public class AddressUtils {

	public static List<AddressDTO> convertToAddressDtoList(List<Address> list){
		List<AddressDTO> dtoList=new ArrayList<AddressDTO>();
		for(Address address : list) {
			dtoList.add(convertToAddressDto(address));
		}
		return dtoList;
	}	

	public static AddressDTO convertToAddressDto(Address address) {
		AddressDTO addressDto =new AddressDTO();
		addressDto.setDoorNo(address.getDoorNo());
		addressDto.setStreet(address.getStreet());
		addressDto.setArea(address.getArea());
		addressDto.setCity(address.getCity());
		addressDto.setState(address.getState());
		return addressDto;
	}
	
	public static Address convertToAddress(AddressDTO addressDto) {
		Address address = new Address();
		address.setDoorNo(addressDto.getDoorNo());
		address.setStreet(addressDto.getStreet());
		address.setArea(addressDto.getArea());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		return address;
	}
}

