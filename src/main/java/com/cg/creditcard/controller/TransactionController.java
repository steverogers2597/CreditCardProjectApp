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

import com.cg.creditcard.entity.Transaction;



import com.cg.creditcard.service.ITransactionService;

@RestController
@RequestMapping("/creditcardapp")
public class TransactionController {
	@Autowired
	ITransactionService transactionService;
	
	
	/* @PostMapping("/creditcard/{cardId}/transactions")
	    public Transaction addTransaction(@PathVariable (value = "cardId") Long cardId,
	                                 @Valid @RequestBody Transaction transaction) {
	        return creditCardRepository.findById(cardId).map(creditCard -> {
	        	transaction.setCreditCard(creditCard);
	            return transactionRepository.save(transaction);
	        }).orElseThrow(() -> new ResourceNotFoundException("CardId " + cardId + " not found"));
	    }*/
	
	@PostMapping("/addTransaction")
	public ResponseEntity addTransaction(@RequestBody Transaction transaction) {
		System.out.println("in controller.....");
		transactionService.addTransaction(transaction);
		return new ResponseEntity("Transaction added successfully!",HttpStatus.OK);
	}
	 
	@DeleteMapping("/removeTransaction/{id}")
	public ResponseEntity removeTransaction(@RequestBody @PathVariable("id")long id) {
		transactionService.removeTransaction(id);
		return new ResponseEntity("Transaction removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateTransaction/{id}")
	public ResponseEntity updateTransaction(@RequestBody @PathVariable("id")long id,Transaction transaction) {
		transactionService.updateTransaction(id, transaction);
		return new ResponseEntity("Transaction updated successfully!",HttpStatus.OK);
	}
	
	@GetMapping("/getTransactionById/{id}")
	public ResponseEntity getTransactionById(@PathVariable("id")long id) {
		Transaction transaction = transactionService.getTransactionDetails(id);
		return new ResponseEntity(transaction,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTransactions")
	public ResponseEntity getAllTransactions(){
		List<Transaction> transactions = transactionService.getAllTransactions();
		ResponseEntity response = new ResponseEntity(transactions,HttpStatus.OK);
		return response;
	}
}
