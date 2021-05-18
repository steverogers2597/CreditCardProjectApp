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

import com.cg.creditcard.entity.Account;
import com.cg.creditcard.model.AccountDTO;
import com.cg.creditcard.service.IAccountService;
import com.cg.creditcard.service.impl.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	IAccountService accountService;
	
	
	@GetMapping("/getAllAccounts")
	public ResponseEntity getAllAccounts(){
		List<AccountDTO> accounts = accountService.getAllAccounts();
		ResponseEntity response = new ResponseEntity(accounts,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAccountById/{id}")
	public ResponseEntity getAccountById(@PathVariable("id")long id) {
		AccountDTO account = accountService.getAccount(id);
		return new ResponseEntity(account,HttpStatus.OK);
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity addAccount(@RequestBody AccountDTO accountdto) {
		accountService.addAccount(accountdto);
		return new ResponseEntity("Account added successfully!",HttpStatus.OK);
	}
	
	@DeleteMapping("/removeAccount/{id}")
	public ResponseEntity removeAccount(@RequestBody @PathVariable("id")long id) {
		accountService.removeAccount(id);
		return new ResponseEntity("Account removed Successfully!",HttpStatus.OK);
	}
	
	@PutMapping("/updateAccount/{id}")
	public ResponseEntity updateAccount(@RequestBody @PathVariable("id")long id,AccountDTO accountdto) {
		accountService.updateAccount(id, accountdto);
		return new ResponseEntity("Account updated successfully!",HttpStatus.OK);
	}
}
