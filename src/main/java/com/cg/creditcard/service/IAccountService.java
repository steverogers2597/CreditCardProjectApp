package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Account;
import com.cg.creditcard.model.AccountDTO;

public interface IAccountService {
	void addAccount(AccountDTO accountdto);
	void removeAccount(long id);
	void updateAccount(long id,AccountDTO accountdto);
	AccountDTO getAccount(long id);
	List<AccountDTO> getAllAccounts();

}
