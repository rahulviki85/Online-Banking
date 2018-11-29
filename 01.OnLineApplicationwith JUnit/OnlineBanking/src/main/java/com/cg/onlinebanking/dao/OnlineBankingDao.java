package com.cg.onlinebanking.dao;


import java.math.BigInteger;


import com.cg.onlinebanking.dto.Customer;

public interface OnlineBankingDao {
public boolean save(Customer customer);
public Customer findOne(BigInteger accountNumber);
}
