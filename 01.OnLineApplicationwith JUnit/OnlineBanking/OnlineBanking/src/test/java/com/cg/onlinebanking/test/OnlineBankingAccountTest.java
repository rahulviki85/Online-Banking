package com.cg.onlinebanking.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.CompareTo;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;

import com.cg.onlinebanking.exception.InvalidInputException;
import com.cg.onlinebanking.services.OnlineBankingAccountServices;
import com.cg.onlinebanking.services.OnlineBankingAccountServicesImpl;

public class OnlineBankingAccountTest {
	private OnlineBankingAccountServices accountServives;
	private Customer customerOne;
	private Customer customerTwo;
	private Customer customerThree;
	private Customer customerFive;
	private Customer customerSix;
	
   @Before
	public void initalValues() {
	   
	   
	  customerOne=new Customer("Rahul","123456781",new Address("Pimpri","Pune","MH"),new Account(new BigInteger("1001"),new BigDecimal(9000),null));
	  customerTwo=new Customer("Vikash","123456789",new Address("MG road","Bangalore","Karnataka"),new Account(new BigInteger("1002"),new BigDecimal(19000),null));
	  customerThree=new Customer("Atul","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1003"),new BigDecimal(9000),null));
	  customerFive=new Customer("Ajay","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1005"),new BigDecimal(1000),null));
	  
	  
	    
	   
	  accountServives=new OnlineBankingAccountServicesImpl();
	}
   @Test
  public void checkBalanceAmount() {
	 assertTrue(validateBalanceAmount(customerThree));
  }
   
   @Test
   public void checkWithDepositAmount() {
	  assertTrue(validateCustomerAfterDeposit(customerTwo));
   }
   @Test
   public void checkFundTransfer() {
	  assertTrue(validateFundTrasfer(customerOne,customerTwo));
   }
   
   @Test
   public void checkWithDrawAmount() {
	  assertTrue(validateCustomerAfterWithDraw(customerFive));
   }
   
   @Test(expected=InvalidInputException.class)
	public void testForInvalidAccountNumber(){
		accountServives.getBalance(new BigInteger("1007"));
	}
   
   
   private boolean validateCustomerAfterDeposit(Customer customer) {
	 
	   Account account=new Account();
	   account.setAccountNumber(customer.getAccount().getAccountNumber());
	   BigDecimal currentBalance=customer.getAccount().getBalance();
	   BigDecimal amount=new BigDecimal(500);
	   BigDecimal newBalance=currentBalance.add(amount);
	   account.setBalance(newBalance);
	   customer.setAccount(account);
	  
	   return customer.getAccount().getBalance().compareTo(accountServives.depositAmount(new BigInteger("1002"),new BigDecimal(500)).getAccount().getBalance())==0;
   }
   private boolean validateBalanceAmount(Customer  customer ) {
	   boolean status=false;
	   BigDecimal dataExpected=customer.getAccount().getBalance();
	   BigDecimal dataActual=accountServives.getBalance(new BigInteger("1003")).getAccount().getBalance();
	   
	   if(dataActual.compareTo(dataExpected)==0)
		   status=true;
	   return status; 
	   
   }
   
   private boolean validateFundTrasfer(Customer customerSource,Customer customerTarget ) {
	  
	   
	   Account accountSource=new Account();
	   accountSource.setAccountNumber(customerSource.getAccount().getAccountNumber());
	   BigDecimal currentBalanceSource=customerSource.getAccount().getBalance();
	   BigDecimal amountSource=new BigDecimal(500);
	  
	   BigDecimal newBalanceSource=currentBalanceSource.subtract(amountSource);
	   
	   accountSource.setBalance(newBalanceSource);
	   customerSource.setAccount(accountSource);
	   
	   Account accountTarget=new Account();
	   accountTarget.setAccountNumber(customerTarget.getAccount().getAccountNumber());
	   BigDecimal currentBalanceTarget=customerTarget.getAccount().getBalance();
	   BigDecimal amountTarget=new BigDecimal(500);
	   BigDecimal newBalanceTarget=currentBalanceTarget.add(amountTarget);
	   
	   accountTarget.setBalance(newBalanceTarget);
	   customerTarget.setAccount(accountTarget);
	
	   return customerSource.getAccount().getBalance().equals(accountServives.fundTrasferAmount(new BigInteger("1001"),new BigInteger("1002"),new BigDecimal(500)).getAccount().getBalance()); 
   }
   
   private boolean validateCustomerAfterWithDraw(Customer customer) {
		 
	   Account account=new Account();
	   account.setAccountNumber(customer.getAccount().getAccountNumber());
	   BigDecimal currentBalance=customer.getAccount().getBalance();
	   BigDecimal amount=new BigDecimal(500);
	   BigDecimal newBalance=currentBalance.subtract(amount);
	   account.setBalance(newBalance);
	   customer.setAccount(account);
	  
	   return customer.getAccount().getBalance().compareTo(accountServives.withdrawAmount(new BigInteger("1005"),new BigDecimal(500)).getAccount().getBalance())==0;
   }
   
   
   
   @After
   public void reAllocating() {
	   customerOne=null;
		customerTwo=null;
		customerThree=null;
		accountServives=null;
   }

}
