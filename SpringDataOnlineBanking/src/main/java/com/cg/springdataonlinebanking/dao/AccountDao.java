package com.cg.springdataonlinebanking.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.springdataonlinebanking.dto.Account;




public interface AccountDao extends CrudRepository<Account,Integer> {
	
}