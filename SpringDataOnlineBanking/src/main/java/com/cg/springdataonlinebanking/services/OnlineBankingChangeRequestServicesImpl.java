package com.cg.springdataonlinebanking.services;


import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springdataonlinebanking.dao.CustomerDao;
import com.cg.springdataonlinebanking.dto.Account;
import com.cg.springdataonlinebanking.dto.Address;
import com.cg.springdataonlinebanking.dto.Customer;



@Service("changerequest")
public class OnlineBankingChangeRequestServicesImpl implements OnlineBankingChangeRequestServices{
    @Autowired
    CustomerDao customerDao;
    
	private static int nextAccountNumber = 100011;
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
        //System.out.println(customer.getPhoneNumber());
        //System.out.println("JJJJJ"+phoneNumber);
        customerDao.save(customer);
		return customer;
	}
	public Customer updateCustomerDetails(Address address, Integer accountNumber) {
		// TODO Auto-generated method stub
		Customer customer = null;
		if(address !=null){
			customer = customerDao.findByAccount(accountNumber);
			System.out.println(customer);
			customer.getAddress().setCity(address.getCity());
			customer.getAddress().setHomeLoaction(address.getHomeLoaction());
			customer.getAddress().setState(address.getState());
			customerDao.save(customer);
		}
		return customer;
	}
	
	
	

}
