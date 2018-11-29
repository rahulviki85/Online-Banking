package com.cg.onlinebanking.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.exception.InsufficientBalanceException;
import com.cg.onlinebanking.exception.InvalidInputException;

public class OnlineBankingAccountServicesImpl implements OnlineBankingAccountServices {
private OnlineBankingDao dao;
	
	public OnlineBankingAccountServicesImpl(Map<BigInteger, Customer> data){
		dao= new OnlineBankingDaoImpl(data);
	}
	public OnlineBankingAccountServicesImpl(OnlineBankingDao dao) {
		super();
		this.dao = dao;
	}

	public OnlineBankingAccountServicesImpl() {
		Map<BigInteger, Customer> data= new HashMap<BigInteger, Customer>();
		dao= new OnlineBankingDaoImpl(data);
}
	public Customer getBalance(BigInteger accountNumber) {
		// TODO Auto-generated method stub
		Customer customer=dao.findOne(accountNumber);
		if(customer!=null ) {
			return customer;}
		else {
			throw new InvalidInputException("Invalid Account Number...... ");
	}
	}

	public Customer depositAmount(BigInteger accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		Customer customer = null;
		if(amount.intValue()>0){
			customer = dao.findOne(accountNumber);
			if(customer!=null && customer.getAccount()!=null){
				Account account = customer.getAccount();
				account.setBalance(account.getBalance().add(amount));
				customer.setAccount(account);;
				dao.save(customer);
				
			}}
		return customer;
	}

	public Customer fundTrasferAmount(BigInteger accountNumberSource,BigInteger accountNumbertarget,BigDecimal amount) {
		// TODO Auto-generated method stub
		
		Customer source = dao.findOne(accountNumberSource);
		Customer target = dao.findOne(accountNumbertarget);
		if(source!=null && target!=null){
		Account sourceAccount = source.getAccount();
		Account targetAccount = target.getAccount();
		
		if(sourceAccount != null && targetAccount != null) {
			if (sourceAccount.getBalance().compareTo(amount)>=0){
				
				sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
				targetAccount.setBalance(sourceAccount.getBalance().add(amount));
			
			
			source.setAccount(sourceAccount);
			target.setAccount(targetAccount);
			
			dao.save(source);
			dao.save(target);
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
	public Customer withdrawAmount(BigInteger accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		Customer customer = dao.findOne(accountNumber);
		//System.out.println(customer+""+accountNumber);
		if(customer!=null && customer.getAccount()!=null){
			if(amount.intValue()<= customer.getAccount().getBalance().intValue()){
			Account account = customer.getAccount();
			account.setBalance(account.getBalance().subtract(amount));
			customer.setAccount(account);
			dao.save(customer);
			return customer;
		}
			else
				throw new InsufficientBalanceException("Low balance for withdraw");
		}
		else
			throw new InvalidInputException("Invalid input");
	}
	
}
