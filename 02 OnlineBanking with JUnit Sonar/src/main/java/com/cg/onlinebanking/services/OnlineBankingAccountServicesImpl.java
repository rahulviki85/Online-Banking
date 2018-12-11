package com.cg.onlinebanking.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.onlinebanking.dao.OnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transaction;
import com.cg.onlinebanking.exception.InsufficientBalanceException;
import com.cg.onlinebanking.exception.InvalidInputException;

public class OnlineBankingAccountServicesImpl implements OnlineBankingAccountServices {
private OnlineBankingDao dao;
Transaction tranOne,tranTwo,tranThree,tranFour;

SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
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
			return customer;
			}
		else {
			throw new InvalidInputException("Invalid Account Number...... ");
	}
	}

	public Customer depositAmount(BigInteger accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		List<Transaction> myAllList=new ArrayList<Transaction>();
		
		
		Customer customer = null;
		if(amount.intValue()>0){
			customer = dao.findOne(accountNumber);
			if(customer!=null && customer.getAccount()!=null){
				Account account = customer.getAccount();
				account.setBalance(account.getBalance().add(amount));
				try {
					tranOne=new Transaction(new BigInteger("10001"),fmt.parse("2018-12-05"),"For Loan",amount,account.getBalance().add(amount));
				    myAllList.add(tranOne);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				account.setTransactionDetail(myAllList);
				customer.setAccount(account);
				dao.save(customer);
				
			}}
		return customer;
	}

	public Customer fundTrasferAmount(BigInteger accountNumberSource,BigInteger accountNumbertarget,BigDecimal amount) {
		// TODO Auto-generated method stub
		List<Transaction> myAllListTwo=new ArrayList<Transaction>();
		List<Transaction> myAllListThree=new ArrayList<Transaction>();
		Customer source = dao.findOne(accountNumberSource);
		Customer target = dao.findOne(accountNumbertarget);
		if(source!=null && target!=null){
		Account sourceAccount = source.getAccount();
		Account targetAccount = target.getAccount();
		
		if(sourceAccount != null && targetAccount != null) {
			if (sourceAccount.getBalance().compareTo(amount)>=0){
				
				sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
				targetAccount.setBalance(sourceAccount.getBalance().add(amount));
				try {
					tranTwo=new Transaction(new BigInteger("10002"),fmt.parse("2018-12-01"),"For Rent",amount,sourceAccount.getBalance().subtract(amount));
					tranThree=new Transaction(new BigInteger("10003"),fmt.parse("2018-12-01"),"For Rent",amount,sourceAccount.getBalance().add(amount));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				myAllListTwo.add(tranTwo);
				myAllListThree.add(tranThree);
				sourceAccount.setTransactionDetail(myAllListTwo);
				targetAccount.setTransactionDetail(myAllListThree);
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
		List<Transaction> myAllListFour=new ArrayList<Transaction>();
		//System.out.println(customer+""+accountNumber);
		
		if(customer!=null && customer.getAccount()!=null){
			if(amount.intValue()<= customer.getAccount().getBalance().intValue()){
			Account account = customer.getAccount();
			account.setBalance(account.getBalance().subtract(amount));
			try {
				tranThree=new Transaction(new BigInteger("10004"),fmt.parse("2018-12-01"),"For Rent",amount,account.getBalance().subtract(amount));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myAllListFour.add(tranFour);
			account.setTransactionDetail(myAllListFour);
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
