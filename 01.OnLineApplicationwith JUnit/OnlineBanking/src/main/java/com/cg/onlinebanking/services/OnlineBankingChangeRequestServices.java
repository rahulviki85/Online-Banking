package com.cg.onlinebanking.services;


import java.math.BigInteger;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingChangeRequestServices {
	
	public Customer createAccount(String name,String phoneNumber,Address address,Account account);
	public Customer updateCustomerDetails(Address address,BigInteger accountNumber);

}
