package com.cg.creditcard.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class StatementDTO {
	
	
	private long statementId;
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;
	private CustomerDTO customer;

	public long getStatementId() {
		return statementId;
	}
	public void setStatementId(long statementId) {
		this.statementId = statementId;
	}
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public StatementDTO(long statementId, double dueAmount, LocalDate billingDate, LocalDate dueDate,
			CustomerDTO customer) {
		super();
		this.statementId = statementId;
		this.dueAmount = dueAmount;
		this.billingDate = billingDate;
		this.dueDate = dueDate;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "StatementDTO [statementId=" + statementId + ", dueAmount=" + dueAmount + ", billingDate=" + billingDate
				+ ", dueDate=" + dueDate + ", customer=" + customer + "]";
	}
	public StatementDTO() {
		super();
		
	}
	
	
	
}
