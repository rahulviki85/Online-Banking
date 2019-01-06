package com.cg.onlinebanking.services;

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

import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Customer;

import com.cg.onlinebanking.exception.InsufficientBalanceException;
import com.cg.onlinebanking.exception.InvalidInputException;

public class OnlineBankingAccountServicesImpl implements OnlineBankingAccountServices {
private OnlineBankingDao dao;
AccountTransaction tranOne,tranTwo,tranThree,tranFour;
private static int nextTransactionNumber = 10000054;
private int transactionGen() {
	return ++nextTransactionNumber;
}
SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	

	public OnlineBankingAccountServicesImpl() {
		//Map<BigInteger, Customer> data= new HashMap<BigInteger, Customer>();
		dao= new OnlineBankingDaoImpl();
}
	public Customer getBalance(Integer accountNumber) {
		// TODO Auto-generated method stub
		
		Customer customer=dao.findOne(accountNumber);
	
		if(customer!=null ) {
			return customer;
			}
		else {
			throw new InvalidInputException("Invalid Account Number...... ");
	}
	}

	public Customer depositAmount(Integer accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		
		Customer customer = null;
		System.out.println(accountNumber);
		if(amount.intValue()>0){
			customer = dao.findOne(accountNumber);
			System.out.println(customer);
			if(customer!=null && customer.getAccount()!=null){
				Account account = customer.getAccount();
				account.setBalance(account.getBalance().add(amount));
				Date date = new Date();
				customer.setAccount(account);
				dao.save(customer);
				
				AccountTransaction accountTransaction=new AccountTransaction(transactionGen(),date,"For Food", amount, account.getBalance(), account);
				System.out.println("In service"+accountTransaction);
				dao.saveTranSaction(accountTransaction);
				
			}}
		return customer;
	}

	public Customer fundTrasferAmount(Integer accountNumberSource,Integer accountNumbertarget,BigDecimal amount) {
		
		// TODO Auto-generated method stub
		
		Customer source = dao.findOne(accountNumberSource);
		Customer target = dao.findOne(accountNumbertarget);
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
			AccountTransaction accountTransaction=new AccountTransaction(transactionGen(),date,"For Rent", amount, sourceAccount.getBalance(), sourceAccount);
			dao.saveTranSaction(accountTransaction);	
			
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
	public Customer withdrawAmount(Integer accountNumber, BigDecimal amount) {
				// TODO Auto-generated method stub
		Customer customer = dao.findOne(accountNumber);
		
		if(customer!=null && customer.getAccount()!=null){
			if(amount.intValue()<= customer.getAccount().getBalance().intValue()){
			Account account = customer.getAccount();
			account.setBalance(account.getBalance().subtract(amount));
			
			customer.setAccount(account);
			dao.save(customer);
			Date date=new Date();
			AccountTransaction accountTransactionWithdraw=new AccountTransaction(transactionGen(),date,"For Book", amount, account.getBalance(), account);
			dao.saveTranSaction(accountTransactionWithdraw);	
			return customer;
		}
			else
				throw new InsufficientBalanceException("Low balance for withdraw");
		}
		else
			throw new InvalidInputException("Invalid input");
	
	}
	
}
