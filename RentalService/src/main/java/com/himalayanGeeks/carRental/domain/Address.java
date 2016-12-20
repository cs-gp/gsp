package com.himalayanGeeks.carRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@Size(min=2, max=50)
	public String city;

	@Size(min=2, max=50)
	public String state;	

	@Min(10000)
	@Max(99999)
	public int zip;
	
	@Size(min=2, max=30)
	public String street;
	public boolean isShipping=false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public boolean isShipping() {
		return isShipping;
	}
	public void setShipping(boolean isShipping) {
		this.isShipping = isShipping;
	}

}
