package com.cg.onlinebanking.dao;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.staticdb.CustomerDb;

public class OnlineBankingDaoImpl implements OnlineBankingDao {
	private Map<BigInteger, Customer> allListData=new HashMap<BigInteger, Customer>();
	
	public OnlineBankingDaoImpl(Map<BigInteger, Customer> allListData) {
		super();
		this.allListData=CustomerDb.getAllCustomer();
	}
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		allListData.put(customer.getAccount().getAccountNumber(), customer);
		return true;
	}

	public Customer findOne(BigInteger accountNumber) {
		// TODO Auto-generated method stub
		
		return allListData.get(accountNumber);
	}
	

}
