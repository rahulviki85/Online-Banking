package com.cg.onlinebanking.services;

import java.math.BigInteger;

import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingPrintServices {
	
	public Customer getAllAccountDetails(BigInteger accountNumber);

}
