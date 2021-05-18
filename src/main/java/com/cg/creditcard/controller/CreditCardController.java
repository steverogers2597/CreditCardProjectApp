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


import com.cg.creditcard.model.CreditCardDTO;
import com.cg.creditcard.service.ICreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	@Autowired
	ICreditCardService creditCardService;
	@PostMapping("/addCreditCard")
	public ResponseEntity addCreditcard(@RequestBody CreditCardDTO credircarddto) {
		creditCardService.addCreditCard(credircarddto);
		return new ResponseEntity("Creditcard added successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removeCreditCard/{id}")
	public ResponseEntity removeCreditCard(@RequestBody @PathVariable("id")long id) {
		creditCardService.removeCreditCard(id);
		return new ResponseEntity("creditCard removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateCreditCard{id}")
	public ResponseEntity updateCreditCard(@RequestBody @PathVariable("id")long id,CreditCardDTO credircarddto) {
		creditCardService.updateCreditCard(id, credircarddto);
		return new ResponseEntity("CreditCard updated successfully!",HttpStatus.OK);
	}
	@GetMapping("/getCreditCardById/{id}")
	public ResponseEntity getAccountById(@PathVariable("id")long id) {
		CreditCardDTO creditcard = creditCardService.getCreditCard(id);
		return new ResponseEntity(creditcard,HttpStatus.OK);
	}
	@GetMapping("/getAllCreditCards")
	public ResponseEntity getAllCreditCards(){
		List<CreditCardDTO> creditcards = creditCardService.getAllCreditCards();
		ResponseEntity response = new ResponseEntity(creditcards,HttpStatus.OK);
		return response;
	}
}