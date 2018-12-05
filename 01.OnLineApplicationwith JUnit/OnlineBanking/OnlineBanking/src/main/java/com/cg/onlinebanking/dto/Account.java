package com.cg.onlinebanking.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class Account {
	private BigInteger accountNumber;
	private BigDecimal balance;
	private List<Transaction> transactionDetail;
	
public Account() {
	
}

public Account(BigInteger accountNumber, BigDecimal balance, List<Transaction> transactionDetail) {
	super();
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.transactionDetail = transactionDetail;
}

public BigInteger getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(BigInteger accountNumber) {
	this.accountNumber = accountNumber;
}

public BigDecimal getBalance() {
	return balance;
}

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

public List<Transaction> getTransactionDetail() {
	return transactionDetail;
}

public void setTransactionDetail(List<Transaction> transactionDetail) {
	this.transactionDetail = transactionDetail;
}

@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", transactionDetail="
			+ transactionDetail + "]";
}




}
