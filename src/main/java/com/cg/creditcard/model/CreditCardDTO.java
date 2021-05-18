package com.cg.creditcard.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class CreditCardDTO {
	
	private Long id;
	private String cardName;
	private String cardType;
	private String cardNumber;
	private LocalDate expiryDate;
	private String bankName;
	private int cvv;
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public CreditCardDTO() {
		// TODO Auto-generated constructor stub
	}
	public CreditCardDTO(long id, String cardName, String cardType, String cardNumbe, LocalDate expiryDate, String bankName,
		int cvv) {
	super();
	this.id = id;
	this.cardName = cardName;
	this.cardType = cardType;
	this.cardNumber = cardNumber;
	this.expiryDate = expiryDate;
	this.bankName = bankName;
	this.cvv = cvv;
}

	@Override
	public String toString() {
		return "CreditCardDTO [id=" + id + ", cardName=" + cardName + ", cardType=" + cardType + ", cardNumbe="
				+ cardNumber + ", expiryDate=" + expiryDate + ", bankName=" + bankName + ", cvv=" + cvv + "]";
	}
	
	
	
}
