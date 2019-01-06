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
	  date=fmt.parse("2019-01-06");
	}
    /*@Test
	public void checkgivenAccountTransaction() {
    	
		assertEquals(1,accountServives.getAccountDetailsParicularDate(1007,date).size());
	}*/
    
    @Test
   	public void checkSevenDaysAccountTransaction() {
    	
   		assertEquals(1,accountServives.getAccountDetailsSevenDate(100002,date).size());
   	}
    
   
}
