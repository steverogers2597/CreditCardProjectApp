package com.cg.creditcard.utils;

import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.model.PaymentDTO;

public class PaymentUtils {
	
	public static PaymentDTO convertToPaymentDto(Payment payment)
	{
		PaymentDTO paymentDto=new PaymentDTO();
		paymentDto.setPaymentId(payment.getPaymentId());
		paymentDto.setMethod(payment.getMethod());
		paymentDto.setAmountDue(payment.getAmountDue());
		return paymentDto;
	}
	
	public static Payment convertToPayment(PaymentDTO paymentDto)
	{
		Payment payment=new Payment();
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setMethod(paymentDto.getMethod());
		payment.setAmountDue(paymentDto.getAmountDue());
		return payment;
	}

}
