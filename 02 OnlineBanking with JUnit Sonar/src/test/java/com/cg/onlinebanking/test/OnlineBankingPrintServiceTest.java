package com.cg.onlinebanking.test;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import com.cg.onlinebanking.services.OnlineBankingPrintServices;
import com.cg.onlinebanking.services.OnlinebankingPrintServicesImpl;

public class OnlineBankingPrintServiceTest {
	private OnlineBankingPrintServices accountServives;
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	Date date;
	@Before
	public void initalValues() throws ParseException {
	  accountServives=new OnlinebankingPrintServicesImpl();
	  date=fmt.parse("2018-12-11");
	}
    @Test
	public void checkgivenAccountTransaction() {
    	
		assertEquals(1,accountServives.getAccountDetailsParicularDate(new BigInteger("1007"),date).size());
	}
    
    @Test
   	public void checkSevenDaysAccountTransaction() {
    	
   		assertEquals(2,accountServives.getAccountDetailsSevenDate(new BigInteger("1007"),date).size());
   	}
    
   
}
