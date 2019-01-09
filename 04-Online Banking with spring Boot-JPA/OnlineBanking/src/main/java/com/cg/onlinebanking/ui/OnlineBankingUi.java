package com.cg.onlinebanking.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;

@SpringBootApplication
@ComponentScan(basePackages="com.cg.onlinebanking")
public class OnlineBankingUi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(OnlineBankingUi.class, args);
		
	}

}
