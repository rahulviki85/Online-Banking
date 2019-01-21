package com.cg.springdataonlinebanking.dao;




import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.springdataonlinebanking.dto.Customer;



public interface CustomerDao extends JpaRepository<Customer,String> {
	
	
	Customer findByAccount(Integer accountNumber);
}