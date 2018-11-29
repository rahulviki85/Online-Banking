package com.cg.onlinebanking.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Account {
	private BigInteger accountNumber;
	private BigDecimal balance;
	private Transaction transactionDetail;
	
public Account() {
	
}

public Account(BigInteger accountNumber, BigDecimal balance, Transaction transactionDetail) {
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

public Transaction getTransactionDetail() {
	return transactionDetail;
}

public void setTransactionDetail(Transaction transactionDetail) {
	this.transactionDetail = transactionDetail;
}

@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", transactionDetail="
			+ transactionDetail + "]";
}




}
