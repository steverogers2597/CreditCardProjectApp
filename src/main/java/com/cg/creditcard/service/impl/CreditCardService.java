package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.creditcard.entity.CreditCard;


import com.cg.creditcard.repository.CreditCardRepository;
import com.cg.creditcard.service.ICreditCardService;


@Service
public class CreditCardService implements ICreditCardService{
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	public List<CreditCard> getAllCreditCards(){
		List<CreditCard> credList= creditCardRepository.findAll();
		return credList;
	}
	
	public CreditCard getCreditCard(long cardId) {
		Optional<CreditCard> optional = creditCardRepository.findById(cardId);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public CreditCard addCreditCard(CreditCard creditCard) {
		
		return creditCardRepository.saveAndFlush(creditCard);
		
	}
	
	public void removeCreditCard(long cardId) {
		
		creditCardRepository.deleteById(cardId);
	}
	
	public CreditCard updateCreditCard(long cardId,CreditCard card) {
		
		Optional<CreditCard> optional = creditCardRepository.findById(cardId);
		if(!optional.isPresent()) {
			
			return null;
		}
		card=optional.get();
		return creditCardRepository.save(card);
	}
}
