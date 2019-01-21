package com.cg.springdataonlinebanking.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springdataonlinebanking.dao.AccountTransactionDao;
import com.cg.springdataonlinebanking.dao.CustomerDao;
import com.cg.springdataonlinebanking.dto.AccountTransaction;
import com.cg.springdataonlinebanking.dto.Customer;



@Service("printservices")
public class OnlinebankingPrintServicesImpl implements OnlineBankingPrintServices{
@Autowired
private AccountTransactionDao acctranDao;
@Autowired
private CustomerDao customerDao;
	
	
	public List<AccountTransaction> getAccountDetailsParicularDate(Integer accountNumber, Date start) {
		// TODO Auto-generated method stub
		//Customer customer=customerDao.findByAccount(accountNumber);
		
		
		List<AccountTransaction> giveData =acctranDao.find(accountNumber,start);
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
		//Customer customer=customerDao.findByAccount(accountNumber);
		//System.out.println(customer);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		cal.add(Calendar.DATE,-7);
		Date dateBeforeSevenDays = cal.getTime();
		System.out.println("7 days before"+dateBeforeSevenDays);
		List<AccountTransaction> giveData =acctranDao.findBeforeSeven(accountNumber,dateBeforeSevenDays,start);
		//List<AccountTransaction> giveData=null;
		//System.out.println(giveData);
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
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
				
	}
	public Customer findAccountId(Integer accountNumber) {
		List<Customer> allCustomer=customerDao.findAll();
		//Customer allCustomer=dao.findAll().forEach(cust-> cust.getAccount().getAccountNumber().intValue()==accountNumber);;
		Customer customer=null;
		for (Customer cust : allCustomer) {
			System.out.println(cust);
			if(cust.getAccount().getAccountNumber().intValue()==accountNumber) {
				customer=new Customer();
				customer=cust;
				
				break;
			}
		
	}
		return customer;
	}	
	
	

	

	

}
