package com.cg.onlinebanking.services;


import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;


public class OnlineBankingChangeRequestServicesImpl implements OnlineBankingChangeRequestServices{
private OnlineBankingDao dao;
	
	
	

	public OnlineBankingChangeRequestServicesImpl() {
		
		dao= new OnlineBankingDaoImpl();
		
}
	
	private static int nextAccountNumber = 100002;
	private int accountGen() {
		return ++nextAccountNumber;
	}
	public Customer createAccount(String name, String phoneNumber, Address address, Account account) {
		// TODO Auto-generated method stub
		
		Customer customer = new Customer();
		
		Account accountCreate=new Account();
		accountCreate.setAccountNumber(accountGen());
		accountCreate.setBalance(new BigDecimal(0.0));
		System.out.println(accountCreate.getAccountNumber());
		customer.setAddress(address);
		customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setAccount(accountCreate);
		dao.save(customer);
		return customer;
	}
	public Customer updateCustomerDetails(Address address, Integer accountNumber) {
		// TODO Auto-generated method stub
		Customer customer = null;
		if(address !=null){
			customer = dao.findOne(accountNumber);
			System.out.println(customer);
			customer.getAddress().setCity(address.getCity());
			customer.getAddress().setHomeLoaction(address.getHomeLoaction());
			customer.getAddress().setState(address.getState());
			dao.save(customer);
		}
		return customer;
	}
	
	
	

}
