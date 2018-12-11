package com.cg.onlinebanking.staticdb;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;


public class CustomerDb {
	private static Map<BigInteger,Customer> allCustomerList=new HashMap<BigInteger, Customer>();
	private static Customer customerOne;
	private static Customer customerTwo;
	private static Customer customerThree;
	private static Customer customerFive;
	private static Customer customerSeven;
	static Transaction tranOne,tranTwo,tranThree;
	
	private static List<Transaction> myAllList;
	static {
		customerOne=new Customer("Rahul","123456781",new Address("Pimpri","Pune","MH"),new Account(new BigInteger("1001"),new BigDecimal(9000),null));
		  customerTwo=new Customer("Vikash","123456789",new Address("MG road","Bangalore","Karnataka"),new Account(new BigInteger("1002"),new BigDecimal(19000),null));
		  customerThree=new Customer("Atul","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1003"),new BigDecimal(9000),null));
		  customerFive=new Customer("Ajay","891111111",new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1005"),new BigDecimal(1000),null));
		  myAllList=new ArrayList<Transaction>();
		  SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		  
		   try {
			tranOne=new Transaction(new BigInteger("10001"),fmt.parse("2018-11-05"),"For Loan",new BigDecimal(500),new BigDecimal(4000));
			tranTwo=new Transaction(new BigInteger("10002"),fmt.parse("2018-12-11"),"For Rent",new BigDecimal(100),new BigDecimal(3900));
			tranThree=new Transaction(new BigInteger("10003"),fmt.parse("2018-12-10"),"For Food",new BigDecimal(100),new BigDecimal(3800));
		   } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
		   myAllList.add(tranOne);
		   myAllList.add(tranTwo);
		   myAllList.add(tranThree);
		   
		   customerSeven=new Customer("Daya","999199100", new Address("Airoli","Mumbai","MH"),new Account(new BigInteger("1007"),new BigDecimal(3500),myAllList));	   
		  
	  allCustomerList=new HashMap<BigInteger, Customer>();
	  allCustomerList.put(customerOne.getAccount().getAccountNumber(),customerOne);
	  allCustomerList.put(customerTwo.getAccount().getAccountNumber(),customerTwo);
	  allCustomerList.put(customerThree.getAccount().getAccountNumber(),customerThree);
	  allCustomerList.put(customerFive.getAccount().getAccountNumber(),customerFive);
	  allCustomerList.put(customerSeven.getAccount().getAccountNumber(),customerSeven);
	}
	
public static Map<BigInteger,Customer> getAllCustomer() {
		
		return allCustomerList;
	}

	public static void setCustomerList(Map<BigInteger,Customer> customerList) {
		
		CustomerDb.allCustomerList = customerList;
	}

}
