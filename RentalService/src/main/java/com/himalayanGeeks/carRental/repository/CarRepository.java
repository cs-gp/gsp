package com.himalayanGeeks.carRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.CarType;

/**
 * Created by Vikas on 8/31/2016.
 */

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    @Query("select c from Car c where c.name = :name")
    Car findByCarName(@Param("name") String name);
    @Query("select c from Car c where c.available = 1")
    List<Car> findavailableCar();
}

