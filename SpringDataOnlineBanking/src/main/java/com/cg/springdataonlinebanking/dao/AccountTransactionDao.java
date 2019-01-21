package com.cg.springdataonlinebanking.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.springdataonlinebanking.dto.AccountTransaction;

public interface AccountTransactionDao extends CrudRepository<AccountTransaction,Integer> {
    @Query("SELECT at FROM  AccountTransaction at JOIN at.savingsAccount a WHERE a.accountNumber=:account AND at.transactionDate=:date")
	List<AccountTransaction> find(@Param("account") Integer accountNumber,@Param("date") Date startDate);
    
    @Query("SELECT at FROM  AccountTransaction at JOIN at.savingsAccount a WHERE a.accountNumber=:account AND at.transactionDate BETWEEN :two AND :one")
	List<AccountTransaction> findBeforeSeven(@Param("account") Integer accountNumber,@Param("two") Date startDate,@Param("one") Date endDate);
}
