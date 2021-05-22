package com.cg.creditcard.service;

import com.cg.creditcard.entity.Payment;
public interface IPaymentService {
	Payment addPayment(Payment payment);
	void removePayment(long id);
	Payment updatePayment(long id,Payment payment);
	Payment getPayment(long id);
}
