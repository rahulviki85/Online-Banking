package com.cg.onlinebanking.staticdb;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServicesImpl;

public class CustomerDb {
	private static Map<BigInteger,Customer> allCustomerList=new HashMap<BigInteger, Customer>();
	private static Customer customerOne;
	private static Customer customerTwo;
	private static Customer customerThree;
	private static Customer customerFive;
	static {
	  customerOne=new Customer("Rahul","123456781",new Address("Pimpri","Pune","MH"),new Account(new BigInteger("1001"),new BigDecimal(9000),new Transaction(new BigInteger("10001"),new Date(),"This is monthy payment",new BigDecimal(9000),new BigDecimal(19000))));
	  customerTwo=new Customer("Vikash","123456789",new Address("MG road","Bangalore","Karnataka"),new Account(new BigInteger("1002"),new BigDecimal(19000),new Transaction(new BigInteger("10002"),new Date(),"This is monthy payment",new BigDecimal(19000),new BigDecimal(29000))));
	  customerThree=new Customer("Atul","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1003"),new BigDecimal(9000),new Transaction(new BigInteger("10003"),new Date(),"This is monthy payment",new BigDecimal(9000),new BigDecimal(19000))));
	  customerFive=new Customer("Ajay","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1005"),new BigDecimal(1000),new Transaction(new BigInteger("10005"),new Date(),"This is monthy payment",new BigDecimal(1000),new BigDecimal(1000))));
	  allCustomerList=new HashMap<BigInteger, Customer>();
	  allCustomerList.put(customerOne.getAccount().getAccountNumber(),customerOne);
	  allCustomerList.put(customerTwo.getAccount().getAccountNumber(),customerTwo);
	  allCustomerList.put(customerThree.getAccount().getAccountNumber(),customerThree);
	  allCustomerList.put(customerFive.getAccount().getAccountNumber(),customerFive);
	}
	
public static Map<BigInteger,Customer> getAllCustomer() {
		
		return allCustomerList;
	}

	public static void setCustomerList(Map<BigInteger,Customer> customerList) {
		
		CustomerDb.allCustomerList = customerList;
	}

}
