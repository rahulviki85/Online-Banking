package com.cg.springdataonlinebanking.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages="com.cg.springdataonlinebanking")
@EnableJpaRepositories(basePackages="com.cg.springdataonlinebanking")
@EntityScan(basePackages="com.cg.springdataonlinebanking")
public class OnlineBankingUi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(OnlineBankingUi.class, args);
		
	}

}
