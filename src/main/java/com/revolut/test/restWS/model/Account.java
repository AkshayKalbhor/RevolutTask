package com.revolut.test.restWS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private int accountNumber;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private Double balance;
	
	public Account(){};
	
	public Account(String firstName2, String lastName2, int accountNo, Double balance) {
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.accountNumber = accountNo;
		this.balance = balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
