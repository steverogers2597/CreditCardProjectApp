package com.cg.creditcard.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.model.PaymentDTO;
import com.cg.creditcard.repository.PaymentRepository;
import com.cg.creditcard.service.IPaymentService;
import com.cg.creditcard.utils.PaymentUtils;

@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	PaymentRepository paymentRepository;
	
	public PaymentDTO getPayment(long PaymentId) {
		PaymentDTO paymentDTO =new PaymentDTO();
		Optional<Payment> optional = paymentRepository.findById(PaymentId);
		if(optional.isPresent()) {
			Payment payment=optional.get();
			paymentDTO= PaymentUtils.convertToPaymentDto(payment);
		}
		return paymentDTO;
	}
	
	public void addPayment(PaymentDTO paymentDTO) {
		
		paymentRepository.saveAndFlush(PaymentUtils.convertToPayment(paymentDTO));
		
	}
	
	public void removePayment(long PaymentId) {
		
		paymentRepository.deleteById(PaymentId);
	}
	
	public void updatePayment(long PaymentId,PaymentDTO paymentDTO) {
		
		Optional<Payment> optional = paymentRepository.findById(PaymentId);
		if(optional.isPresent()) {
			Payment payment=optional.get();
			paymentRepository.save(PaymentUtils.convertToPayment(paymentDTO));
			
		}
	}

	

}
