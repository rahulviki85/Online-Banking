package com.cg.onlinebanking.controller;



import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.services.OnlineBankingAccountServices;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServices;
import com.cg.onlinebanking.services.OnlinebankingPrintServicesImpl;


@RestController
@RequestMapping(value="/banking")
public class OnlineBankingController {
	@Autowired
	OnlineBankingChangeRequestServices changerequest;
	@Autowired
	OnlineBankingAccountServices accountservices;
	@Autowired
	OnlinebankingPrintServicesImpl printservices;
	@RequestMapping(value="/createaccount",produces="application/json",method=RequestMethod.POST)
	public Customer createAccount(@RequestParam("phoneNumber") String phone,@RequestParam("name") String userName,
			@RequestParam("homeLoaction") String home,@RequestParam("city") String city,@RequestParam("state") String state ) {
		
		Address address=new Address(home,city,state);
		
		return changerequest.createAccount(userName, phone, address, null);
		
	}
	@RequestMapping(value="/update",produces="application/json",method=RequestMethod.POST)
	public Customer updateCustomer(@RequestParam("homeLoaction") String home,@RequestParam("city") String city,@RequestParam("state") String state ,@RequestParam("accountnumber") Integer accountNumber) {
		Address address=new Address(home, city, state);
		return changerequest.updateCustomerDetails(address,accountNumber);
		
	}
	@RequestMapping(value="/getbalance",produces="application/json",method=RequestMethod.POST)
	public Customer getBalance(@RequestParam("accountnumber") Integer accNumber) {
		return accountservices.getBalance(accNumber) ;
		
	}
	
	@RequestMapping(value="/deposit",produces="application/json",method=RequestMethod.POST)
	public Customer depositAmount(@RequestParam("accountnumber") Integer accNumber,@RequestParam("amount") BigDecimal amount,@RequestParam("desc") String description) {
		return accountservices.depositAmount(accNumber, amount,description) ;
		
	}
	@RequestMapping(value="/fundtransfer",produces="application/json",method=RequestMethod.POST)
	public Customer fundTrasferAmount(@RequestParam("sourceaccountnumber") Integer sourceAccNumber,@RequestParam("targetaccountnumber") Integer targetAccNumber,@RequestParam("amount") BigDecimal amount,
			@RequestParam("desc") String description) {
		return accountservices.fundTrasferAmount(sourceAccNumber, targetAccNumber, amount,description) ;
		
	}
	
	@RequestMapping(value="/withdraw",produces="application/json",method=RequestMethod.POST)
	public Customer withdrawAmount(@RequestParam("accountnumber") Integer accNumber,@RequestParam("amount") BigDecimal amount,
			@RequestParam("desc") String description) {
		return accountservices.withdrawAmount(accNumber,amount,description) ;
		
	}
	@RequestMapping(value="/particulardate",produces="application/json",method=RequestMethod.POST)
	public List<AccountTransaction> getAccountDetailsParicularDate(@RequestParam("accountnumber") Integer accountNumber,@RequestParam("date") String start){
		String sDate1=start;
		Date date1=null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in converting...");
			e.printStackTrace();
		}
		System.out.println(sDate1+"\t"+date1);
		return printservices.getAccountDetailsParicularDate(accountNumber,date1);
		
	}
	@RequestMapping(value="/sevendays",produces="application/json",method=RequestMethod.POST)
	public List<AccountTransaction> getAccountDetailsParicularSevenDate(@RequestParam("accountnumber") Integer accountNumber,@RequestParam("date") String start){
		String sDate1=start;
		//String eDate1=end;
		Date date1=null;
	//	Date date2=null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			//date2 = new SimpleDateFormat("dd/MM/yyyy").parse(eDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in converting...");
			e.printStackTrace();
		}
		System.out.println(sDate1+"\t"+date1);
		return printservices.getAccountDetailsSevenDate(accountNumber, date1);
		
	}
	@RequestMapping(value="/alldata",produces="application/json",method=RequestMethod.GET)
	public List<Customer> getAllData(){
		return printservices.getAllCustomer();
		
	}
}
