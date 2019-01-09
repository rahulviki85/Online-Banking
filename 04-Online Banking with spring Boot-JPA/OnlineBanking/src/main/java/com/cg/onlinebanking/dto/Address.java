package com.cg.onlinebanking.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String homeLoaction; 
	private String city;
	private String state; 
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String homeLoaction, String city, String state) {
		super();
		this.homeLoaction = homeLoaction;
		this.city = city;
		this.state = state;
	}

	public String getHomeLoaction() {
		return homeLoaction;
	}

	public void setHomeLoaction(String homeLoaction) {
		this.homeLoaction = homeLoaction;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [homeLoaction=" + homeLoaction + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
