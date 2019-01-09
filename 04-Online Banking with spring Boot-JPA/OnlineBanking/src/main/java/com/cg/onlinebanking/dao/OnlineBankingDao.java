package com.cg.onlinebanking.dao;



import java.util.Date;
import java.util.List;


import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingDao {
public boolean save(Customer customer);
public Customer findOne(Integer accountNumber);
public boolean saveTranSaction(AccountTransaction dao);
public List<Customer> getAllCustomer();
public List<AccountTransaction> getTrasactionByDate(Date date,Integer account);
public List<AccountTransaction> getTrasactionBetweenDate(Date fromDate,Date toDate,Integer account);
}
