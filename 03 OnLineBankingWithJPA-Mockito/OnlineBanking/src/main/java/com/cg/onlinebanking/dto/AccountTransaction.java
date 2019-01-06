package com.cg.onlinebanking.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class AccountTransaction {
	@Id
    private Integer transactionId;
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	private String description;
	private BigDecimal amount;
	private BigDecimal balance;
	@ManyToOne
	private Account savingsAccount;
	
	public Account getSavingsAccount() {
		return savingsAccount;
	}
	public void setSavingsAccount(Account savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	public AccountTransaction() {
		
	}
	



	public AccountTransaction(Integer transactionId, Date transactionDate, String description, BigDecimal amount,
			BigDecimal balance, Account savingsAccount) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
		this.savingsAccount = savingsAccount;
	}
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
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
