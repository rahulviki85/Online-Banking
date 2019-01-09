package com.cg.onlinebanking.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="customerdata")
public class Customer {
	
	@Id
	private String phoneNumber;
   
	private String name;
	
	@Embedded
	private Address address;
	@OneToOne(cascade=CascadeType.ALL)
	private Account account;
	
	public Customer(){
		
	}

	public Customer(String name, String phoneNumber, Address address, Account account) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [" + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", account=" + account + "]";
	}

}
