package com.cg.onlinebanking.mockitotest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.onlinebanking.dto.Address;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.services.OnlineBankingAccountServices;
import com.cg.onlinebanking.services.OnlineBankingChangeRequestServices;
@RunWith(MockitoJUnitRunner.class)
public class OnlineBankingDaoTest {

	@Test
	public void createAccountTest() {
		Customer customer=new Customer("Diva","211118",new Address("Kothrud","Pune","MH"),null);
		OnlineBankingChangeRequestServices changeService=Mockito.mock(OnlineBankingChangeRequestServices.class);
		when(changeService.createAccount("Diva","211118",new Address("Kothrud","Pune","MH"),null)).thenReturn(customer);
	}
	
	

}
