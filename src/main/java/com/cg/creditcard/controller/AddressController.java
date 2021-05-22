package com.cg.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.entity.Address;
import com.cg.creditcard.service.IAddressService;

@RestController
@RequestMapping("/creditcardapp")
public class AddressController {
	@Autowired
	IAddressService addressService;
	
	@PostMapping("/addAddress")
	public ResponseEntity addAddress(@RequestBody Address address) {
		addressService.addAddress(address);
		return new ResponseEntity("Address added successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateAddress/{id}")
	public ResponseEntity updateAddress(@RequestBody @PathVariable("id")Integer addrId, Address address) {
		addressService.updateAddress(addrId,address);
		return new ResponseEntity("Address updated successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removeAddress/{id}")
	public ResponseEntity removeAddress(@RequestBody @PathVariable("id") Integer addrId) {
		addressService.removeAddress(addrId);
		return new ResponseEntity("Address removed Successfully!",HttpStatus.OK);
	}
	@GetMapping("/getAddressById/{id}")
	public ResponseEntity getAddressById(@PathVariable("id")Integer addrId) {
		Address address = addressService.getAddress(addrId);
		return new ResponseEntity(address,HttpStatus.OK);
	}
	@GetMapping("/getAllAddresses")
	public ResponseEntity getAllAddresses(){
		List<Address> addresses = addressService.getAllAddresses();
		ResponseEntity response = new ResponseEntity(addresses,HttpStatus.OK);
		return response;
	}
}
