package com.cg.onlinebanking.dao;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingDao {
	public Customer getBalance(BigInteger accountNumber);
	public Customer depositAmount(BigInteger accountNumber,BigDecimal amount);
	public Customer fundTrasferAmount(BigInteger accountNumber,BigDecimal amount);
	public Customer createAccount(BigInteger accountNumber,Address address,String phoneNumber,BigDecimal accountbalance);
	public Customer updateCustomerDetails(Address address,String phoneNumber);
	public Customer getAllAccountDetails(BigInteger accountNumber);
}
