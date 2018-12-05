package com.cg.onlinebanking.dto;

public class Customer {
	
	
	private String name;
	private String phoneNumber;
	private Address address;
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
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", account="
				+ account + "]";
	}

}
