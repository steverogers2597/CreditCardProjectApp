package com.cg.creditcard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long paymentId;
	String method;
	double amountDue;
	@ManyToOne
	@JoinColumn(name="creditcard__id")
	private CreditCard creditCard;
	
	
	
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Payment(long paymentId, String method, double amountDue,CreditCard creditCard) {
		super();
		this.paymentId = paymentId;
		this.method = method;
		this.amountDue = amountDue;
		this.creditCard=creditCard;
	}

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

	

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", method=" + method + ", amountDue=" + amountDue + "]";
	}

	public Payment() {
		super();
		
	}
	
	
}
