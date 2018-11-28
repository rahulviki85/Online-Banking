package com.cg.onlinebanking.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;
import com.cg.onlinebanking.services.OnlineBankingAccountServices;
import com.cg.onlinebanking.services.OnlineBankingAccountServicesImpl;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServices;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServicesImpl;

public class OnLineBankingChangeRequestTest {
	
	private OnlineBankingChangeRequestServices changeRequestServives;
	private Customer customerOne;
	private Customer customerTwo;
	private Customer customerThree;
	private Customer customerFour;
	private Map<String,Customer> allCustomerList;
	
   @Before
	public void initalValues() {
	   customerOne=new Customer("Rahul","123456781",new Address("Pimpri","Pune","MH"),new Account(new BigInteger("1001"),new BigDecimal(9000),new Transaction(new BigInteger("10001"),new Date(),"This is monthy payment",new BigDecimal(9000),new BigDecimal(19000))));
		  customerTwo=new Customer("Vikash","123456789",new Address("MG road","Bangalore","Karnataka"),new Account(new BigInteger("1002"),new BigDecimal(19000),new Transaction(new BigInteger("10002"),new Date(),"This is monthy payment",new BigDecimal(19000),new BigDecimal(29000))));
		  customerThree=new Customer("Atul","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1003"),new BigDecimal(9000),new Transaction(new BigInteger("10003"),new Date(),"This is monthy payment",new BigDecimal(9000),new BigDecimal(19000))));
	  changeRequestServives=new OnlineBankingChangeRequestServicesImpl();
	  allCustomerList=new HashMap<String, Customer>();
	  allCustomerList.put(customerOne.getPhoneNumber(),customerOne);
	  allCustomerList.put(customerTwo.getPhoneNumber(),customerTwo);
	  allCustomerList.put(customerThree.getPhoneNumber(),customerThree);
	}
   @Test
   public void checkValidCreateAccount() {
	  
	  assertEquals(4.0,validateNewAccount());
   }
   @Test
   public void checkValidChangeAddress() {
	   assertTrue(validateChangeAddress(customerOne));
   }
   
   private double validateNewAccount() {
	   
	   customerFour=new Customer("Sagar","111111111",new Address("Kothrud","Pune","MH"),new Account(new BigInteger("1004"),new BigDecimal(39000),new Transaction(new BigInteger("10004"),new Date(),"This is monthy payment",new BigDecimal(39000),new BigDecimal(0))));
	   allCustomerList.put(customerFour.getPhoneNumber(), customerFour);
	   return  allCustomerList.size();
   }
   private boolean validateChangeAddress(Customer cust) {
	   Address address=new Address();
	   address.setHomeLoaction("Ravet");
	   address.setCity(cust.getAddress().getCity());
	   address.setState(cust.getAddress().getState());
	   cust.setAddress(address);
	return cust.getAddress().getHomeLoaction().equals("Ravet");
	   
   }

}
