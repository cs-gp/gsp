package com.himalayanGeeks.carRental.service;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.CarType;

import java.util.List;

import org.springframework.data.repository.query.Param;

/**
 * Created by Vikas on 8/31/2016.
 */
public interface CarService {
    void save(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
    Car getCarByName(String name);
    void delete(int id);
    List<Car> findavailableCar();
   
    //List<Car> getAvailableCars();
}
