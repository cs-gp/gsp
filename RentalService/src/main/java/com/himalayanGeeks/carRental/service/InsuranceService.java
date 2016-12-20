package com.himalayanGeeks.carRental.service;

import java.util.List;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.Insurance;

public interface InsuranceService {

	
	void save(Insurance Insurance);
    List<Insurance> getAllInsurance();
    Insurance getInsuranceById(int id);
}
