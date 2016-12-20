package com.himalayanGeeks.carRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Insurance {
	public int costPerDay;
	public String coveredType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String name;

	public int getCostPerDay() {
		return costPerDay;
	}

	public String getCoveredType() {
		return coveredType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}

	public void setCoveredType(String coveredType) {
		this.coveredType = coveredType;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
