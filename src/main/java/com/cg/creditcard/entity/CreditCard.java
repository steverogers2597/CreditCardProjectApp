package com.cg.creditcard.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Card")
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String bankName;
	private String cardType;
	private String cardName;
	private String cardNumber;
    private String expiryDate;
    private int cvv;
    
    /*@OneToMany(mappedBy = "creditCard", cascade=CascadeType.ALL)
    private List<Payment> payments;*/
    
    @OneToMany(mappedBy = "creditCard" ,cascade=CascadeType.ALL)
    private List<Transaction> transactions;
	
	
	public CreditCard(long id, String bankName, String cardType, String cardName, String cardNumber,
			String expiryDate, int cvv, List<Transaction> transactions) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.cardType = cardType;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		
		this.transactions = transactions;
	}



	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
	/*public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}*/
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", bankName=" + bankName + ", cardType=" + cardType + ", cardName=" + cardName
				+ ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", payments="
				 + ", transactions=" + transactions + "]";
	}
    
}
