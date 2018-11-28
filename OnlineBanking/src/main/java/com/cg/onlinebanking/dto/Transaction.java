package com.cg.onlinebanking.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Transaction {
	
	private BigInteger transactionId;
	private Date transactionDate;
	private String description;
	private BigDecimal amount;
	private BigDecimal balance;
	
	public Transaction() {
		
	}

	public Transaction(BigInteger transactionId, Date transactionDate, String description, BigDecimal amount,
			BigDecimal balance) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}

	public BigInteger getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", description="
				+ description + ", amount=" + amount + ", balance=" + balance + "]";
	}
	
	
	

}
