package com.himalayanGeeks.carRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CarType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public int numberOfCylinder;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumberOfCylinder() {
		return numberOfCylinder;
	}
	public void setNumberOfCylinder(int numberOfCylinder) {
		this.numberOfCylinder = numberOfCylinder;
	}
	public int getNoOfPerson() {
		return noOfPerson;
	}
	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	public String getCarManufacturer() {
		return carManufacturer;
	}
	public void setCarManufacturer(String carManufacturer) {
		this.carManufacturer = carManufacturer;
	}
	public int noOfPerson;
	public String carManufacturer;
	
	
}
