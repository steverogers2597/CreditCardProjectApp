package com.cg.creditcard.model;

import org.springframework.stereotype.Component;

@Component
public class AccountDTO {

	private long accountId;
	private String accountName;
	private double balance;
	private String accountType;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountid) {
		this.accountId = accountid;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accounttype) {
		this.accountType = accounttype;
	}
	
	
	public AccountDTO(long accountId, String accountName, double balance, String accounttype) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.accountType = accounttype;
	}
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
				+ ", accounttype=" + accountType + "]";
	}
	
	
	
}
