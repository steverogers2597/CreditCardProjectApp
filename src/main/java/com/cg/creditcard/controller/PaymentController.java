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

import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.service.IPaymentService;

@RestController
@RequestMapping("/creditcardapp")
public class PaymentController {
	@Autowired
	IPaymentService paymentService;
	@PostMapping("/addPayment")
	public ResponseEntity addPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
		return new ResponseEntity("Payment added successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removePayment/{id}")
	public ResponseEntity removePayment(@RequestBody @PathVariable("id")long id) {
		paymentService.removePayment(id);
		return new ResponseEntity("Payment removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updatePayment/{id}")
	public ResponseEntity updatePayment(@RequestBody @PathVariable("id")long id,Payment payment) {
		paymentService.updatePayment(id, payment);
		return new ResponseEntity("Payment updated successfully!",HttpStatus.OK);
	}
	@GetMapping("/getPaymentById/{id}")
	public ResponseEntity getPaymentById(@PathVariable("id")long id) {
		Payment payment = paymentService.getPayment(id);
		return new ResponseEntity(payment,HttpStatus.OK);
	}
	
}