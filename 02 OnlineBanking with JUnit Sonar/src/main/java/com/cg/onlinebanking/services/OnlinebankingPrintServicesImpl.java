package com.cg.onlinebanking.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;

public class OnlinebankingPrintServicesImpl implements OnlineBankingPrintServices{
private OnlineBankingDao dao;
public OnlinebankingPrintServicesImpl() {
	Map<BigInteger, Customer> data= new HashMap<BigInteger, Customer>();
	dao= new OnlineBankingDaoImpl(data);
}
	public OnlinebankingPrintServicesImpl(Map<BigInteger, Customer> data){
		dao= new OnlineBankingDaoImpl(data);
	}
	public OnlinebankingPrintServicesImpl(OnlineBankingDao dao) {
		super();
		this.dao = dao;
	}
	public List<Transaction> getAccountDetailsParicularDate(BigInteger accountNumber, Date start) {
		// TODO Auto-generated method stub
		Customer customer=dao.findOne(accountNumber);
		
		Transaction tran;
		List<Transaction> giveData =  new ArrayList<Transaction>() ;
		
		List<Transaction> custTransaction=customer.getAccount().getTransactionDetail();
		Iterator<Transaction>itr=custTransaction.iterator();
		
		while(itr.hasNext()) {
			tran=itr.next();
		int status=	tran.getTransactionDate().compareTo(start);
				if(status==0) {
					giveData.add(tran);
					System.out.println();
				}
			
		}
	
		return giveData;
	}
	public List<Transaction> getAccountDetailsSevenDate(BigInteger accountNumber, Date start) {
		// TODO Auto-generated method stub
		Customer customer=dao.findOne(accountNumber);
		//System.out.println(customer);
		Transaction tran;
		List<Transaction> giveData = new ArrayList<Transaction>() ;
		
		List<Transaction> custTransaction=customer.getAccount().getTransactionDetail();
		Iterator<Transaction>itr=custTransaction.iterator();
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
			
		
		//System.out.println(giveData.size());
		return giveData;
	}
	
	
	

	

	

}
