package com.cg.creditcard.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tranId;
	private String cardNumber;
	private String tranDate;
	private String status;
	private double amount;
	private String paymentMethod;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="creditcard__id")
	private CreditCard creditCard;
	
	
	public Transaction(long tranId, String cardNumber, String tranDate, String status, double amount,
			String paymentMethod, String description,CreditCard creditCard) {
		super();
		this.tranId = tranId;
		this.cardNumber = cardNumber;
		this.tranDate = tranDate;
		this.status = status;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.creditCard=creditCard;
	}

	public long getTranId() {
		return tranId;
	}

	public void setTranId(long tranId) {
		this.tranId = tranId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate + ", status="
				+ status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description=" + description
				+ ", creditCard=" + creditCard + "]";
	}

	public Transaction() {
		super();
		
	}
	
}
