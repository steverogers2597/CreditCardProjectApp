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
import com.cg.creditcard.model.CustomerDTO;
import com.cg.creditcard.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	@PostMapping("/addCustomer")
	public ResponseEntity addAccount(@RequestBody CustomerDTO customerdto) {
		customerService.addCustomer(customerdto);
		return new ResponseEntity("Customer added successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removeCustomer/{id}")
	public ResponseEntity removeCustomer(@RequestBody @PathVariable("id")String id) {
		customerService.removeCustomer(id);
		return new ResponseEntity("Customer removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity updateCustomer(@RequestBody @PathVariable("id")String id,CustomerDTO customerdto) {
		customerService.updateCustomer(id, customerdto);
		return new ResponseEntity("Customer info updated successfully!",HttpStatus.OK);
	}
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity getCustomerById(@PathVariable("id")String id) {
		CustomerDTO customer = customerService.getCustomer(id);
		return new ResponseEntity(customer,HttpStatus.OK);
	}
	@GetMapping("/getAllCustomers")
	public ResponseEntity getAllCustomers(){
		List<CustomerDTO> customers = customerService.getAllCustomers();
		ResponseEntity response = new ResponseEntity(customers,HttpStatus.OK);
		return response;
	}
}