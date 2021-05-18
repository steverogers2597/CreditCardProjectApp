package com.cg.creditcard.controller;

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
import com.cg.creditcard.model.PaymentDTO;
import com.cg.creditcard.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	IPaymentService paymentService;
	@PostMapping("/addPayment")
	public ResponseEntity addPayment(@RequestBody PaymentDTO paymentdto) {
		paymentService.addPayment(paymentdto);
		return new ResponseEntity("Payment added successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removePayment/{id}")
	public ResponseEntity removePayment(@RequestBody @PathVariable("id")long id) {
		paymentService.removePayment(id);
		return new ResponseEntity("Payment removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updatePayment/{id}")
	public ResponseEntity updateAccount(@RequestBody @PathVariable("id")long id,PaymentDTO paymentdto) {
		paymentService.updatePayment(id, paymentdto);
		return new ResponseEntity("Payment updated successfully!",HttpStatus.OK);
	}
	@GetMapping("/getPaymentById/{id}")
	public ResponseEntity getPaymentById(@PathVariable("id")long id) {
		 PaymentDTO payment = paymentService.getPayment(id);
		return new ResponseEntity(payment,HttpStatus.OK);
	}
	
}