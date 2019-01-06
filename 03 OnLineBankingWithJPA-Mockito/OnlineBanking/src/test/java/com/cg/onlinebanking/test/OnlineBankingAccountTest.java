package com.cg.onlinebanking.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

import com.cg.onlinebanking.exception.InvalidInputException;
import com.cg.onlinebanking.services.OnlineBankingAccountServices;
import com.cg.onlinebanking.services.OnlineBankingAccountServicesImpl;

public class OnlineBankingAccountTest {
	private OnlineBankingAccountServices accountServives;
	
   @Before
	public void initalValues() {
	    
	   
	  accountServives=new OnlineBankingAccountServicesImpl();
	}
   /*@Test
  public void checkBalanceAmount() {
	// assertTrue(validateBalanceAmount(new BigInteger("1009")));
  }*/
   
   @Test
   public void checkWithDepositAmount() {
	 //assertTrue(validateCustomerAfterDeposit(100002, new BigDecimal("100")));
   }
   @Test
   public void checkFundTransfer() {
	  //assertTrue(validateFundTrasfer(100002,100003,new BigDecimal(100)));
   }
   
   @Test
   public void checkWithDrawAmount() {
	 assertTrue(validateCustomerAfterWithDraw(100002,new BigDecimal(100)));
   }
   
   //@Test(expected=InvalidInputException.class)
	public void testForInvalidAccountNumber(){
		//accountServives.getBalance(new BigInteger("1009"));
	}
   
   
   private boolean validateCustomerAfterDeposit(Integer accountNumber, BigDecimal amount) {
	 
	   Customer customer=accountServives.depositAmount(accountNumber,amount);
	  
	   return customer.getAccount().getBalance().compareTo(new BigDecimal("100"))==0;
   }
   private boolean validateBalanceAmount(Integer accountNumber ) {
	   boolean status=false;
	   
	   Customer dataActual=accountServives.getBalance(accountNumber);
	   
	   if(dataActual.getAccount().getBalance().compareTo(new BigDecimal(38000))==0)
		   status=true;
	   return status; 
	   
   }
   
   private boolean validateFundTrasfer(Integer source,Integer target,BigDecimal amount) {
	  
	   Customer dataCall=accountServives.fundTrasferAmount(source, target, amount);
	   
	   return dataCall.getAccount().getBalance().compareTo(new BigDecimal("100"))==0;
	   
	
	  
   }
   
   private boolean validateCustomerAfterWithDraw(Integer source,BigDecimal amount) {
		 
	   Customer dataCall=accountServives.withdrawAmount(source, amount);
	  
	   return dataCall.getAccount().getBalance().compareTo(new BigDecimal("200"))==0;
   }
   
   
   
   @After
   public void reAllocating() {
	   
		accountServives=null;
   }

}
