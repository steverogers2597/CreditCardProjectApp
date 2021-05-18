package com.cg.creditcard.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.creditcard.entity.Account;
import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.model.AccountDTO;
import com.cg.creditcard.model.CustomerDTO;

public class AccountUtills {

	public static List<AccountDTO> convertToAccountDtoList(List<Account> list){
		List<AccountDTO> dtoList=new ArrayList<AccountDTO>();
		for(Account account : list) {
			dtoList.add(convertToAccountDto(account));
		}
		return dtoList;
	}

	public static AccountDTO convertToAccountDto(Account account) {
		AccountDTO accountDto =new AccountDTO();
		accountDto.setAccountId(account.getAccountId());
		accountDto.setAccountName(account.getAccountName());
		accountDto.setBalance(account.getBalance());
		accountDto.setAccountType(account.getAccountType());
		
		return accountDto;
	}
	
	public static Account convertToAccount(AccountDTO accountDto) {
		Account account = new Account();
		account.setAccountId(accountDto.getAccountId());
		account.setAccountName(accountDto.getAccountName());
		account.setBalance(accountDto.getBalance());
		account.setAccountType(accountDto.getAccountType());
		
		return account;
	}
}
