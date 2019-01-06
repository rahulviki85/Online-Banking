package com.cg.onlinebanking.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Iterator;
import java.util.List;


import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Customer;


public class OnlinebankingPrintServicesImpl implements OnlineBankingPrintServices{
private OnlineBankingDao dao;
public OnlinebankingPrintServicesImpl() {
	
	dao= new OnlineBankingDaoImpl();
}
	
	
	public List<AccountTransaction> getAccountDetailsParicularDate(Integer accountNumber, Date start) {
		// TODO Auto-generated method stub
		Customer customer=dao.findOne(accountNumber);
		
		
		List<AccountTransaction> giveData =dao.getTrasactionByDate(new Date(),accountNumber);
		System.out.println(giveData);
		/*List<AccountTransaction> custTransaction=customer.getAccount().getTransactionDetail();
		Iterator<AccountTransaction>itr=custTransaction.iterator();
		
		while(itr.hasNext()) {
			tran=itr.next();
		int status=	tran.getTransactionDate().compareTo(start);
				if(status==0) {
					giveData.add(tran);
					
				}
			
		}*/
	
		return giveData;
	}
	public List<AccountTransaction> getAccountDetailsSevenDate(Integer accountNumber, Date start) {
		// TODO Auto-generated method stub
		Customer customer=dao.findOne(accountNumber);
		//System.out.println(customer);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		cal.add(Calendar.DATE,-7);
		Date dateBeforeSevenDays = cal.getTime();
		System.out.println("7 days before"+dateBeforeSevenDays);
		List<AccountTransaction> giveData =dao.getTrasactionBetweenDate(start,dateBeforeSevenDays, accountNumber);
		System.out.println(giveData);
		/*List<AccountTransaction> custTransaction=customer.getAccount().getTransactionDetail();
		Iterator<AccountTransaction>itr=custTransaction.iterator();
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		cal.add(Calendar.DATE,-7);
		Date dateBeforeSevenDays = cal.getTime();
		
		while(itr.hasNext()) {
			tran =itr.next();
			
			if(!tran.getTransactionDate().before(dateBeforeSevenDays))
				giveData.add(tran);
			//System.out.println(giveData);
			}
			*/
		
		//System.out.println(giveData.size());
		return giveData;
	}
	
	
	

	

	

}
