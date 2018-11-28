package com.cg.onlinebanking.dao;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;

public class OnlineBankingDaoImpl implements OnlineBankingDao {

	public Customer getBalance(BigInteger accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer depositAmount(BigInteger accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer fundTrasferAmount(BigInteger accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer createAccount(BigInteger accountNumber, Address address, String phoneNumber,
			BigDecimal accountbalance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer updateCustomerDetails(Address address, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getAllAccountDetails(BigInteger accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
