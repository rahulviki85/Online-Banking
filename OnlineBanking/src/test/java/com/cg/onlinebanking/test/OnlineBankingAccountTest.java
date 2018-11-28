package com.cg.onlinebanking.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;
import com.cg.onlinebanking.services.OnlineBankingAccountServices;
import com.cg.onlinebanking.services.OnlineBankingAccountServicesImpl;

public class OnlineBankingAccountTest {
	private OnlineBankingAccountServices accountServives;
	private Customer customerOne;
	private Customer customerTwo;
	private Customer customerThree;
   @Before
	public void initalValues() {
	   customerOne=new Customer("Rahul","123456781",new Address("Pimpri","Pune","MH"),new Account(new BigInteger("1001"),new BigDecimal(9000),new Transaction(new BigInteger("10001"),new Date(),"This is monthy payment",new BigDecimal(9000),new BigDecimal(19000))));
	  customerTwo=new Customer("Vikash","123456789",new Address("MG road","Bangalore","Karnataka"),new Account(new BigInteger("1002"),new BigDecimal(19000),new Transaction(new BigInteger("10002"),new Date(),"This is monthy payment",new BigDecimal(19000),new BigDecimal(29000))));
	  customerThree=new Customer("Atul","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1003"),new BigDecimal(9000),new Transaction(new BigInteger("10003"),new Date(),"This is monthy payment",new BigDecimal(9000),new BigDecimal(19000))));
		accountServives=new OnlineBankingAccountServicesImpl();
	}
   @Test
  public void checkBalanceAmount() {
	 assertTrue(validateBalanceAmount(customerTwo));
  }
   
   @Test
   public void checkWithDepositAmount() {
	   assertTrue(validateCustomerAfterDeposit(customerOne));
   }
   @Test
   public void checkFundTransfer() {
	   assertTrue(validateFundTrasfer(customerTwo));
   }
   
   
   private boolean validateCustomerAfterDeposit(Customer customer) {
	 
	   Account account=new Account();
	   account.setAccountNumber(customer.getAccount().getAccountNumber());
	   BigDecimal currentBalance=customer.getAccount().getBalance();
	   BigDecimal amount=new BigDecimal(500);
	   BigDecimal newBalance=currentBalance.add(amount);
	   account.setBalance(newBalance);
	   customer.setAccount(account);
	  
	   return customer.getAccount().getBalance().compareTo(new BigDecimal(9500))==0;
   }
   private boolean validateBalanceAmount(Customer customer) {
	return customer.getAccount().getBalance().compareTo(new BigDecimal(19000))==0; 
	   
   }
   
   private boolean validateFundTrasfer(Customer customer) {
	   Account account=new Account();
	   account.setAccountNumber(customer.getAccount().getAccountNumber());
	   BigDecimal currentBalance=customer.getAccount().getBalance();
	   BigDecimal amount=new BigDecimal(500);
	   BigDecimal newBalance=currentBalance.subtract(amount);
	   
	   account.setBalance(newBalance);
	   customer.setAccount(account);
	  
	   return customer.getAccount().getBalance().compareTo(new BigDecimal(18500))==0; 
   }
   
   
   
   @After
   public void reAllocating() {
	   customerOne=null;
		 customerTwo=null;
		customerThree=null;
		accountServives=null;
   }

}
