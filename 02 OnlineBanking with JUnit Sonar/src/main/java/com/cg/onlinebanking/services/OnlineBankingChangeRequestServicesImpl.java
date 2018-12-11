package com.cg.onlinebanking.services;


import java.math.BigInteger;

import java.util.HashMap;
import java.util.Map;

import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;


public class OnlineBankingChangeRequestServicesImpl implements OnlineBankingChangeRequestServices{
private OnlineBankingDao dao;
	
	public OnlineBankingChangeRequestServicesImpl(Map<BigInteger, Customer> data){
		dao= new OnlineBankingDaoImpl(data);
	}
	public OnlineBankingChangeRequestServicesImpl(OnlineBankingDao dao) {
		super();
		this.dao = dao;
	}

	public OnlineBankingChangeRequestServicesImpl() {
		Map<BigInteger, Customer> data= new HashMap<BigInteger, Customer>();
		dao= new OnlineBankingDaoImpl(data);
}
	public Customer createAccount(String name, String phoneNumber, Address address, Account account) {
		// TODO Auto-generated method stub
		Customer customer = null;
		if(account.getAccountNumber()!=null) {
			customer=new Customer(name,phoneNumber,address,account);
			dao.save(customer);
			
		}
		return customer;
	}
	public Customer updateCustomerDetails(Address address, BigInteger accountNumber) {
		// TODO Auto-generated method stub
		Customer customer = null;
		if(address !=null){
			customer = dao.findOne(accountNumber);
			customer.getAddress().setCity(address.getCity());
			customer.getAddress().setHomeLoaction(address.getHomeLoaction());
			customer.getAddress().setState(address.getState());
		}
		return customer;
	}
	
	
	

}
