package com.cg.onlinebanking.test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;


import org.junit.Before;
import org.junit.Test;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

import com.cg.onlinebanking.services.OnlineBankingChangeRequestServices;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServicesImpl;

public class OnLineBankingChangeRequestTest {
	
	private OnlineBankingChangeRequestServices changeRequestServives;
	private Customer customerOne;
	
	private Customer customerFour;

	
   @Before
	public void initalValues() {
	   customerOne=new Customer("Rahul","123456781",new Address("Pimpri","Pune","MH"),new Account(new BigInteger("1001"),new BigDecimal(9000),null));
	   customerFour=changeRequestServives.createAccount("Sagar","111111111",new Address("Kothrud","Pune","MH"),new Account(new BigInteger("1004"),new BigDecimal(39000),null)); 
		  
	  changeRequestServives=new OnlineBankingChangeRequestServicesImpl();
	  
	}
   @Test
   public void checkValidCreateAccount() {
	   
	  assertEquals("Sagar",customerFour.getName());
   }
   @Test
   public void checkValidChangeAddress() {
	   assertTrue(validateChangeAddress(customerOne));
   }
   
  
   private boolean validateChangeAddress(Customer cust) {
	   Address address=new Address();
	   address.setHomeLoaction("Ravet");
	   address.setCity(cust.getAddress().getCity());
	   address.setState(cust.getAddress().getState());
	   cust.setAddress(address);
	   Customer customerNew=changeRequestServives.updateCustomerDetails(address,new BigInteger("1001"));
	   
	return cust.getAddress().getHomeLoaction().equals(customerNew.getAddress().getHomeLoaction());
	   
   }

}
