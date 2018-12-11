package com.cg.onlinebanking.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


import com.cg.onlinebanking.dto.Transaction;

public interface OnlineBankingPrintServices {
	
	public List<Transaction> getAccountDetailsParicularDate(BigInteger accountNumber,Date start);
	public List<Transaction> getAccountDetailsSevenDate(BigInteger accountNumber,Date start);
}
