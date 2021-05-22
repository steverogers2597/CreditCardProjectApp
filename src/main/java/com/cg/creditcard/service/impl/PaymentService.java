package com.cg.creditcard.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcard.entity.CreditCard;
import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.repository.CreditCardRepository;
import com.cg.creditcard.repository.PaymentRepository;
import com.cg.creditcard.service.IPaymentService;


@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	public Payment getPayment(long PaymentId) {
		Optional<Payment> optional = paymentRepository.findById(PaymentId);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public Payment addPayment(Payment payment) {
		 CreditCard creditcard = creditCardRepository.findById(payment.getCreditCard().getId()).get();
	        if (null == creditcard) {
	        	creditcard = new CreditCard();
	        }

	        creditcard.setBankName(payment.getCreditCard().getBankName());
	        creditcard.setCardType(payment.getCreditCard().getCardType());
	        creditcard.setCardName(payment.getCreditCard().getCardName());
	        creditcard.setCardNumber(payment.getCreditCard().getCardNumber());
	        creditcard.setExpiryDate(payment.getCreditCard().getExpiryDate());
	        creditcard.setCvv(payment.getCreditCard().getCvv());
	        
	        payment.setCreditCard(creditcard);
	        return paymentRepository.save(payment);
		
	}
	
	public void removePayment(long PaymentId) {
		
		paymentRepository.deleteById(PaymentId);
	}
	
	public Payment updatePayment(long PaymentId,Payment payment) {
		
		Optional<Payment> optional = paymentRepository.findById(PaymentId);
		if(!optional.isPresent()) {
			
			return null;
		}
		payment=optional.get();
		return paymentRepository.save(payment);
	}

	

}
