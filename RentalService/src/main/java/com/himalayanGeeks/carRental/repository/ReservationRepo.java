package com.himalayanGeeks.carRental.repository;

import org.springframework.data.repository.CrudRepository;

import com.himalayanGeeks.carRental.domain.Reservation;

public interface ReservationRepo extends CrudRepository<Reservation, Integer>{
	
	
	

}
