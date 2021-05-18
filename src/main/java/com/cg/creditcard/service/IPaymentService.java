package com.cg.creditcard.service;

import com.cg.creditcard.entity.Payment;
import com.cg.creditcard.model.PaymentDTO;

public interface IPaymentService {
	void addPayment(PaymentDTO paymentdto);
	void removePayment(long id);
	void updatePayment(long id,PaymentDTO paymentdto);
	PaymentDTO getPayment(long id);
}
