package com.cg.onlinebanking.services;

import java.math.BigDecimal;
import java.math.BigInteger;


import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingAccountServices {
	
	
	public Customer getBalance(Integer accountNumber);
	public Customer depositAmount(Integer accountNumber,BigDecimal amount);
	public Customer fundTrasferAmount(Integer accountNumber,Integer accountNumbertarget,BigDecimal amount);
	public Customer withdrawAmount(Integer accountNumber, BigDecimal amount) ;
	
	}
