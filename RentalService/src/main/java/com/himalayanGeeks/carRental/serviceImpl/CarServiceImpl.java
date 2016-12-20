package com.himalayanGeeks.carRental.serviceImpl;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.CarType;
import com.himalayanGeeks.carRental.repository.CarRepository;
import com.himalayanGeeks.carRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vikas on 8/31/2016.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        System.out.println("here");
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.findOne(id);
    }

    @Override
    public Car getCarByName(String name) {
        return carRepository.findByCarName(name);
    }

    @Override
    public void delete(int id) {
        carRepository.delete(id);
    }
    
    @Override
    public List<Car> findavailableCar(){
    	return carRepository.findavailableCar();
    }
/*
	@Override
	public List<Car> getAvailableCars() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
