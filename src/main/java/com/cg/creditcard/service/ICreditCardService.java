package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.CreditCard;


public interface ICreditCardService {
	CreditCard addCreditCard(CreditCard creditCarddto);
	void removeCreditCard(long cardId);
	CreditCard updateCreditCard(long cardId,CreditCard card);
	CreditCard getCreditCard(long cardId);
	List<CreditCard> getAllCreditCards();
	
}
