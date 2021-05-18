package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Transaction;
import com.cg.creditcard.model.TransactionDTO;

public interface ITransactionService {
	void addTransaction(TransactionDTO transactiondto);
	void removeTransaction(long id);
	void updateTransaction(long id,TransactionDTO transactiondto);
	TransactionDTO getTransactionDetails(long id);
	List<TransactionDTO> getAllTransactions();
}
