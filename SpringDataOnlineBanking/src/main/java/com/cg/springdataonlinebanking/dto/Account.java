package com.cg.springdataonlinebanking.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Account implements Serializable {
	@Id
	@Column(name="account_number")
	private Integer accountNumber;
	private BigDecimal balance;
	@OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AccountTransaction> transactionDetail=new ArrayList<AccountTransaction>();
	
public Account() {}
public Account(Integer accountNumber, BigDecimal balance, List<AccountTransaction> transactionDetail) {
	super();
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.transactionDetail = transactionDetail;
}
public Integer getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Integer accountNumber) {
	this.accountNumber = accountNumber;
}
public BigDecimal getBalance() {
	return balance;
}
public void setBalance(BigDecimal balance) {
	this.balance = balance;
}
public List<AccountTransaction> getTransactionDetail() {
	return transactionDetail;
}
public void setTransactionDetail(List<AccountTransaction> transactionDetail) {
	
	this.transactionDetail = transactionDetail;
}
@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", transactionDetail="
			+ transactionDetail + "]";
}




}
