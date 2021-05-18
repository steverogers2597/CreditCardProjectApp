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
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.model.StatementDTO;
import com.cg.creditcard.model.TransactionDTO;
import com.cg.creditcard.service.ITransactionService;

@RestController
public class TransactionController {
	@Autowired
	ITransactionService transactionService;
	
	@PostMapping("/addTransaction")
	public ResponseEntity addStatement(@RequestBody TransactionDTO transactiondto) {
		transactionService.addTransaction(transactiondto);
		return new ResponseEntity("Transaction added successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removeTransaction/{id}")
	public ResponseEntity removeAccount(@RequestBody @PathVariable("id")long id) {
		transactionService.removeTransaction(id);
		return new ResponseEntity("Transaction removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateTransaction/{id}")
	public ResponseEntity updateStatement(@RequestBody @PathVariable("id")long id,TransactionDTO transactiondto) {
		transactionService.updateTransaction(id, transactiondto);
		return new ResponseEntity("Transaction updated successfully!",HttpStatus.OK);
	}
	@GetMapping("/getTransactionById/{id}")
	public ResponseEntity getAccountById(@PathVariable("id")long id) {
		TransactionDTO transaction = transactionService.getTransactionDetails(id);
		return new ResponseEntity(transaction,HttpStatus.OK);
	}
	@GetMapping("/getAllTransactions")
	public ResponseEntity getAllTransactions(){
		List<TransactionDTO> transactions = transactionService.getAllTransactions();
		ResponseEntity response = new ResponseEntity(transactions,HttpStatus.OK);
		return response;
	}
}
