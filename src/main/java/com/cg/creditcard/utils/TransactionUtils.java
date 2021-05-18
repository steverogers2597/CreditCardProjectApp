package com.cg.creditcard.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.creditcard.entity.Transaction;
import com.cg.creditcard.model.TransactionDTO;

public class TransactionUtils {
	
	public static List<TransactionDTO> convertToTransactionDtoList(List<Transaction> list)
	{
		List<TransactionDTO> dtoList=new ArrayList<TransactionDTO>();
		for(Transaction transaction : list)
		{
			dtoList.add(convertToTransactionDto(transaction));
		}
		return dtoList;
	}

	public static TransactionDTO convertToTransactionDto(Transaction transaction) 
	{
		TransactionDTO transactionDto=new TransactionDTO();
		transactionDto.setTranId(transaction.getTranId());
		transactionDto.setCardNumber(transaction.getCardNumber());
		transactionDto.setTranDate(transaction.getTranDate());
		transactionDto.setStatus(transaction.getStatus());
		transactionDto.setAmount(transaction.getAmount());
		transactionDto.setPaymentMethod(transaction.getPaymentMethod());
		transactionDto.setDescription(transaction.getDescription());
		return transactionDto;
	}
	
	public static Transaction convertToTransaction(TransactionDTO transactionDto)
	{
		Transaction transaction=new Transaction();
		transaction.setTranId(transactionDto.getTranId());
		transaction.setCardNumber(transactionDto.getCardNumber());
		transaction.setTranDate(transactionDto.getTranDate());
		transaction.setStatus(transactionDto.getStatus());
		transaction.setAmount(transactionDto.getAmount());
		transaction.setPaymentMethod(transactionDto.getPaymentMethod());
		transaction.setDescription(transactionDto.getDescription());
		return transaction;
	}

}
