package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.creditcard.entity.CreditCard;

import com.cg.creditcard.entity.Transaction;

import com.cg.creditcard.repository.CreditCardRepository;
import com.cg.creditcard.repository.TransactionRepository;
import com.cg.creditcard.service.ITransactionService;


@Service
public class TransactionService implements ITransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	public List<Transaction> getAllTransactions(){
		return transactionRepository.findAll();
		
	}
	
	public Transaction getTransactionDetails(long id) {
		Optional<Transaction> optional = transactionRepository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public Transaction addTransaction(Transaction transaction) {
		
		
       /* CreditCard creditcard = creditCardRepository.findById(transaction.getCreditCard().getId()).get();
        if (null == creditcard) {
        	creditcard = new CreditCard();
        }

        creditcard.setBankName(transaction.getCreditCard().getBankName());
        creditcard.setCardType(transaction.getCreditCard().getCardType());
        creditcard.setCardName(transaction.getCreditCard().getCardName());
        creditcard.setCardNumber(transaction.getCreditCard().getCardNumber());
        creditcard.setExpiryDate(transaction.getCreditCard().getExpiryDate());
        creditcard.setCvv(transaction.getCreditCard().getCvv());
        
        transaction.setCreditCard(creditcard);*/
        return transactionRepository.save(transaction);

        
		
	}
	
	public void removeTransaction(long id) {
		
		transactionRepository.deleteById(id);
		
	}
	
	public Transaction updateTransaction(long id,Transaction transaction) {
		Optional<Transaction> optional = transactionRepository.findById(id);
		if(!optional.isPresent()) {
			
			return null;
		}
		transaction=optional.get();
		return transactionRepository.save(transaction);
		
	}
}
