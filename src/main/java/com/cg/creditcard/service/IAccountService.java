package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Account;


public interface IAccountService {
	Account addAccount(Account account);
	void removeAccount(long id);
	Account updateAccount(long id,Account account);
	Account getAccount(long id);
	List<Account> getAllAccounts();

}
