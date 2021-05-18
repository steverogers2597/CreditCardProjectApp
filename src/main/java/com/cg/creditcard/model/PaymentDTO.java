package com.cg.creditcard.model;

import org.springframework.stereotype.Component;

@Component
public class PaymentDTO {
	
	
	private long paymentId;
	private String method;
	private double amountDue;
	
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}
	
	
	public PaymentDTO(long paymentId, String method, double amountDue) {
		super();
		this.paymentId = paymentId;
		this.method = method;
		this.amountDue = amountDue;
	}
	
	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", method=" + method + ", amountDue=" + amountDue + "]";
	}
	public PaymentDTO() {
		super();
		
	}
	
}
