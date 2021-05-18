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

import com.cg.creditcard.model.AccountDTO;
import com.cg.creditcard.model.AddressDTO;
import com.cg.creditcard.model.CustomerDTO;
import com.cg.creditcard.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	IAddressService addressService;
	
	@PostMapping("/addAddress")
	public ResponseEntity addAddress(@RequestBody AddressDTO addressdto) {
		addressService.addAddress(addressdto);
		return new ResponseEntity("Address added successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateAddress/{id}")
	public ResponseEntity updateAddress(@RequestBody @PathVariable("id")Integer addrId, AddressDTO addressdto) {
		addressService.updateAddress(addrId,addressdto);
		return new ResponseEntity("Address updated successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removeAddress/{id}")
	public ResponseEntity removeAddress(@RequestBody @PathVariable("id") Integer addrId) {
		addressService.removeAddress(addrId);
		return new ResponseEntity("Address removed Successfully!",HttpStatus.OK);
	}
	@GetMapping("/getAddressById/{id}")
	public ResponseEntity getCustomerById(@PathVariable("id")Integer addrId) {
		AddressDTO address = addressService.getAddress(addrId);
		return new ResponseEntity(address,HttpStatus.OK);
	}
	@GetMapping("/getAllAddresses")
	public ResponseEntity getAllCustomers(){
		List<AddressDTO> addresses = addressService.getAllAddresses();
		ResponseEntity response = new ResponseEntity(addresses,HttpStatus.OK);
		return response;
	}
}
