package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcard.entity.Account;

import com.cg.creditcard.repository.AccountRepository;
import com.cg.creditcard.service.IAccountService;


@Service
public class AccountService implements IAccountService{
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccounts(){
		List<Account> accountList= accountRepository.findAll();
		return accountList;
	}
	
	public Account getAccount(long id) {
		
		Optional<Account> optional = accountRepository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public Account addAccount(Account account) {
		
		return accountRepository.saveAndFlush(account);
		
	}
	
	public void removeAccount(long id) {
		
		accountRepository.deleteById(id);
		 
	}
	
	public Account updateAccount(long id,Account account) {
		
		Optional<Account> optional = accountRepository.findById(id);
		if(!optional.isPresent()) {
			
			return null;
		}
		account=optional.get();
		return accountRepository.save(account);
	}

}
