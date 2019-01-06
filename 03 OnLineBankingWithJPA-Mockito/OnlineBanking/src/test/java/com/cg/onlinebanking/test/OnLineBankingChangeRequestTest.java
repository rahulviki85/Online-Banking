package com.cg.onlinebanking.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

import com.cg.onlinebanking.services.OnlineBankingChangeRequestServices;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServicesImpl;

public class OnLineBankingChangeRequestTest {
	
	private OnlineBankingChangeRequestServices changeRequestServives;
	private Customer customerFour;
	
	
	
   @Before
	public void initalValues() {
	   
       changeRequestServives=new OnlineBankingChangeRequestServicesImpl();
       }
   @Test
   public void checkValidCreateAccount() {
	   
	   customerFour=changeRequestServives.createAccount("Diva","21111118",new Address("Kothrud","Pune","MH"),null);   
	  assertEquals("Diva",customerFour.getName());
   }
   /*@Test
   public void checkValidAddressChange() {
	   Customer customerFive=new Customer("Rahul","111111111",new Address("Ravet","Pune","MH"),new Account(new BigInteger("10001"),new BigDecimal(39000),myAllList));
	   assertTrue(validateChangeAddress(customerFive));
   }*/
   
  
   private boolean validateChangeAddress(Customer cust) {
	   Address address=new Address();
	   address.setHomeLoaction("Ravet");
	   address.setCity(cust.getAddress().getCity());
	   address.setState(cust.getAddress().getState());
	   cust.setAddress(address);
	   
	   changeRequestServives.updateCustomerDetails(address,1008);
	   
	return cust.getAddress().getHomeLoaction().equals("Ravet");
	   
   }

}
