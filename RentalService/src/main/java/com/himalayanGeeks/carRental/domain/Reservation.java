package com.himalayanGeeks.carRental.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String pickupdate;
	public String pickuplocation;
	public String dropoffdate;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "carid_Fk")
	private Car car;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPickuplocation() {
		return pickuplocation;
	}
	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}


	public String getPickupdate() {
		return pickupdate;
	}
	public void setPickupdate(String pickupdate) {
		this.pickupdate = pickupdate;
	}
	public String getDropoffdate() {
		return dropoffdate;
	}
	public void setDropoffdate(String dropoffdate) {
		this.dropoffdate = dropoffdate;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getDropofflocation() {
		return dropofflocation;
	} 
	public void setDropofflocation(String dropofflocation) {
		this.dropofflocation = dropofflocation;
	}
	public String dropofflocation;
}
