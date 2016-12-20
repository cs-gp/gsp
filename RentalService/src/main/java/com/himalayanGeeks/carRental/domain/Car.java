package com.himalayanGeeks.carRental.domain;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


@Entity
public class Car {
	@JsonIgnore
	@Transient
	private MultipartFile carImage;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "carTypeidFk")
    private CarType carType;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "companyidFk")
    private Company company;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "insuranceidFk")
    private Insurance insurance;

	public String name;

	private int numberOfMiles;
	private int pricePerDay;
	public boolean available;
	


	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

	private String year;

	@XmlTransient
	public MultipartFile getCarImage() {
		return carImage;
	}
	public CarType getCarType() {
		return carType;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public int getId() {
		return id;
	}


	public Insurance getInsurance() {
		return insurance;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public String getYear() {
		return year;
	}

	public void setCarImage(MultipartFile carImage) {
		this.carImage = carImage;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void setYear(String year) {
		this.year = year;
	}
	

}
