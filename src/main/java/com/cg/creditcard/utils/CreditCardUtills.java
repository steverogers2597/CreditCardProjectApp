package com.cg.creditcard.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.creditcard.entity.CreditCard;
import com.cg.creditcard.model.CreditCardDTO;


public class CreditCardUtills {
	public static List<CreditCardDTO> convertToCreditCardDtoList(List<CreditCard> list){
		List<CreditCardDTO> dtoList=new ArrayList<CreditCardDTO>();
		for(CreditCard creditCard : list) {
			dtoList.add(convertToCreditCardDto(creditCard));
		}
		return dtoList;
	}

	public static CreditCardDTO convertToCreditCardDto(CreditCard creditCard) {
		CreditCardDTO creditCardDTO =new CreditCardDTO();
		creditCardDTO.setId(creditCard.getId());
		creditCardDTO.setCardName(creditCard.getCardName());
		creditCardDTO.setCardType(creditCard.getCardType());
		creditCardDTO.setCardNumber(creditCard.getCardNumber());
		creditCardDTO.setExpiryDate(creditCard.getExpiryDate());
		creditCardDTO.setBankName(creditCard.getBankName());
		creditCardDTO.setCvv(creditCard.getCvv());
		return creditCardDTO;
	}
	
	public static CreditCard convertToCreditCard(CreditCardDTO creditCardDTO) {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(creditCardDTO.getId());
		creditCard.setCardName(creditCardDTO.getCardName());
		creditCard.setCardType(creditCardDTO.getCardType());
		creditCard.setCardNumber(creditCardDTO.getCardNumber());
		creditCard.setExpiryDate(creditCardDTO.getExpiryDate());
		creditCard.setBankName(creditCardDTO.getBankName());
		creditCard.setCvv(creditCardDTO.getCvv());
		return creditCard;
	}

}
