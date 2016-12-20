package com.himalayanGeeks.carRental.domain;

import java.util.ArrayList;
import java.util.List;

public class CompositeCarModel {

	private static Car car;
	private static CarType carType;
	private static Insurance insurance;
    private static Reservation reservation;
    
    private static List<Car> carList;
    
    public static Reservation getReservationInstance() {
		if (reservation == null) {
			reservation = new Reservation();
		}
		return reservation;
	}
    
    public static List<Car> getCarListInstance() {
		if (carList == null) {
			carList = new ArrayList<Car>();
		}
		return carList;
	}
	public static List<Car> getCarList() {
		return carList;
	}

	public static void setCarList(List<Car> carList) {
		CompositeCarModel.carList = carList;
	}

	public static void setReservation(Reservation reservation) {
		CompositeCarModel.reservation = reservation;
	}


    
    
	public static Car getCarInstance() {
		if (car == null) {
			car = new Car();
		}
		return car;
	}

	public static CarType getCarTypeInstance() {
		if (carType == null) {
			carType = new CarType();
		}
		return carType;
	}

	public static Insurance getInsuranceInstance() {
		if (insurance == null) {
			insurance = new Insurance();
		}
		return insurance;
	}
	public static void setCar(Car car) {
		CompositeCarModel.car = car;
	}



	public static void setCarType(CarType carType) {
		CompositeCarModel.carType = carType;
	}


	public static void setInsurance(Insurance insurance) {
		CompositeCarModel.insurance = insurance;
	}

    
   

}
