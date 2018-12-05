package com.cg.onlinebanking.services;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingAccountServices {
	
	
	public Customer getBalance(BigInteger accountNumber);
	public Customer depositAmount(BigInteger accountNumber,BigDecimal amount);
	public Customer fundTrasferAmount(BigInteger accountNumber,BigInteger accountNumbertarget,BigDecimal amount);
	public Customer withdrawAmount(BigInteger accountNumber, BigDecimal amount);
	
	}
