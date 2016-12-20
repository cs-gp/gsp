package com.himalayanGeeks.carRental.service;

import java.util.List;

import com.himalayanGeeks.carRental.domain.Insurance;
import com.himalayanGeeks.carRental.domain.Reservation;

public interface ReservationService {
	
	void save(Reservation reservation);
    List<Reservation> getAllReservation();

}
