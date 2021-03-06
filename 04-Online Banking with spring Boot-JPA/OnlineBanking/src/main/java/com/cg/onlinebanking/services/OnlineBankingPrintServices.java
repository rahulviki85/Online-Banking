package com.cg.onlinebanking.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Customer;


public interface OnlineBankingPrintServices {
	
	public List<AccountTransaction> getAccountDetailsParicularDate(Integer accountNumber,Date start);
	public List<AccountTransaction> getAccountDetailsSevenDate(Integer accountNumber,Date start);
	public List<Customer> getAllCustomer();
}
