package com.cg.springdataonlinebanking.services;


import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.cg.springdataonlinebanking.dto.Account;
import com.cg.springdataonlinebanking.dto.Address;
import com.cg.springdataonlinebanking.dto.Customer;



public interface OnlineBankingChangeRequestServices {
	
	public Customer createAccount(String name,String phoneNumber,Address address,Account account);
	public Customer updateCustomerDetails(Address address,Integer accountNumber);

}
