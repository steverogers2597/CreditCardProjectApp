package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Transaction;


public interface ITransactionService {
	Transaction addTransaction(Transaction transaction);
	void removeTransaction(long id);
	Transaction updateTransaction(long id,Transaction transaction);
	Transaction getTransactionDetails(long id);
	List<Transaction> getAllTransactions();
}
