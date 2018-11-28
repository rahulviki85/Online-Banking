package com.cg.onlinebanking.services;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingChangeRequestServices {
	
	public Customer createAccount(BigInteger accountNumber,Address address,String phoneNumber,BigDecimal accountbalance);
	public Customer updateCustomerDetails(Address address,String phoneNumber);

}
