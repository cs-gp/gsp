package com.himalayanGeeks.carRental.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.Insurance;


@Repository
public interface InsuranceReposiotry extends CrudRepository<Insurance, Integer> {
	
	  

}
