package com.cg.springdataonlinebanking.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springdataonlinebanking.dao.AccountTransactionDao;
import com.cg.springdataonlinebanking.dao.CustomerDao;
import com.cg.springdataonlinebanking.dto.Account;
import com.cg.springdataonlinebanking.dto.AccountTransaction;
import com.cg.springdataonlinebanking.dto.Customer;
import com.cg.springdataonlinebanking.exception.InsufficientBalanceException;
import com.cg.springdataonlinebanking.exception.InvalidInputException;




@Service("accountservices")
public class OnlineBankingAccountServicesImpl implements OnlineBankingAccountServices {
    @Autowired
	private CustomerDao dao;
    @Autowired
    AccountTransactionDao accDao;
AccountTransaction tranOne,tranTwo,tranThree,tranFour;
private static int nextTransactionNumber = 10000085;
private int transactionGen() {
	return ++nextTransactionNumber;
}
SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	

	
	public Customer getBalance(Integer accountNumber) {
		// TODO Auto-generated method stub
		
		Customer customer=findAccountId(accountNumber);
	
		if(customer!=null ) {
			return customer;
			}
		else {
			throw new InvalidInputException("Invalid Account Number...... ");
	}
	}

	public Customer depositAmount(Integer accountNumber, BigDecimal amount,String description) {
		// TODO Auto-generated method stub
		
		Customer customer = null;
		
		
		System.out.println(accountNumber);
		if(amount.intValue()>0){
			customer=findAccountId(accountNumber);
			
			System.out.println(customer);
			if(customer!=null && customer.getAccount()!=null){
				Account account = customer.getAccount();
				account.setBalance(account.getBalance().add(amount));
				Date date = new Date();
				customer.setAccount(account);
				System.out.println(customer);
				dao.save(customer);
				
				AccountTransaction accountTransaction=new AccountTransaction(transactionGen(),date,description, amount, account.getBalance(), account);
				System.out.println("In service"+accountTransaction);
				accDao.save(accountTransaction);
				
			}}
		return customer;
	}

	public Customer fundTrasferAmount(Integer accountNumberSource,Integer accountNumbertarget,BigDecimal amount,String description) {
		
		// TODO Auto-generated method stub
		
		Customer source = findAccountId(accountNumberSource);
		Customer target = findAccountId(accountNumbertarget);
		if(source!=null && target!=null){
		Account sourceAccount = source.getAccount();
		Account targetAccount = target.getAccount();
		
		if(sourceAccount != null && targetAccount != null) {
			if (sourceAccount.getBalance().compareTo(amount)>=0){
				
				sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
				targetAccount.setBalance(targetAccount.getBalance().add(amount));
				source.setAccount(sourceAccount);
				target.setAccount(targetAccount);
			dao.save(source);
			dao.save(target);
			Date date = new Date();
			AccountTransaction accountTransaction=new AccountTransaction(transactionGen(),date,description, amount, sourceAccount.getBalance(), sourceAccount);
			accDao.save(accountTransaction);
			System.out.println(source);
			return source;
			}
			else
				throw new InsufficientBalanceException("Balance is not sufficient for transfer");
			}
		else
			throw new InvalidInputException("Invalid amount in account");
		}
		else
			throw new InvalidInputException("Invalid input ");
		}
	public Customer withdrawAmount(Integer accountNumber, BigDecimal amount,String description) {
				// TODO Auto-generated method stub
		Customer customer = findAccountId(accountNumber);
		
		if(customer!=null && customer.getAccount()!=null){
			int amountAcual=customer.getAccount().getBalance().intValue();
			int amountGiven=amount.intValue();
			if(amountGiven <=amountAcual ){
			Account account = customer.getAccount();
			account.setBalance(account.getBalance().subtract(amount));
			Date date=new Date();
			customer.setAccount(account);
			dao.save(customer);
			System.out.println("In Services ...."+customer);
			AccountTransaction accountTransactionWithdraw=new AccountTransaction(transactionGen(),date,description, amount, account.getBalance(), account);
			accDao.save(accountTransactionWithdraw);
			return customer;
		}
			else
				throw new InsufficientBalanceException("Low balance for withdraw");
		}
		else
			throw new InvalidInputException("Invalid input");
	
	}
public Customer findAccountId(Integer accountNumber) {
	List<Customer> allCustomer=dao.findAll();
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
