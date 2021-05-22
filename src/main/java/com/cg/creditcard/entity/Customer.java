package com.cg.creditcard.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private String userId;
	private String name;
	private String email;
	private String contactNo;
	private  String dob;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	private Account account;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="statement_id")
	private Statement statement;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="creditcard_id")
	private CreditCard creditcard;	
	
	public Customer(String userId, String name, String email, String contactNo, String dob, Address address,
			Account account, Statement statement, CreditCard creditcard) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
		this.account = account;
		this.statement = statement;
		this.creditcard = creditcard;
	}


	public Customer() {
		super();
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}


	public Statement getStatement() {
		return statement;
	}


	public void setStatement(Statement statement) {
		this.statement = statement;
	}


	public CreditCard getCreditcard() {
		return creditcard;
	}


	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}


	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + ", account=" + account + ", statement=" + statement
				+ ", creditcard=" + creditcard + "]";
	}
	
	
}
