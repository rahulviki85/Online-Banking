package com.cg.springdataonlinebanking.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.cg.springdataonlinebanking.dto.AccountTransaction;
import com.cg.springdataonlinebanking.dto.Customer;




public interface OnlineBankingPrintServices {
	
	public List<AccountTransaction> getAccountDetailsParicularDate(Integer accountNumber,Date start);
	public List<AccountTransaction> getAccountDetailsSevenDate(Integer accountNumber,Date start);
	public List<Customer> getAllCustomer();
}
