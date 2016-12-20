package com.himalayanGeeks.carRental.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himalayanGeeks.carRental.domain.Insurance;
import com.himalayanGeeks.carRental.repository.InsuranceReposiotry;
import com.himalayanGeeks.carRental.service.InsuranceService;

@Service
@Transactional
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	InsuranceReposiotry insurepo;

	@Override
	public void save(Insurance insurance) {
		insurepo.save(insurance);
		
	}

	@Override
	public List<Insurance> getAllInsurance() {
		return (List<Insurance>) insurepo.findAll();
	}

	@Override
	public Insurance getInsuranceById(int id) {
		return insurepo.findOne(id);
	}

}
