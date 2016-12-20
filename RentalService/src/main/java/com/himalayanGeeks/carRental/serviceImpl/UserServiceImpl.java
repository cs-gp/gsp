package com.himalayanGeeks.carRental.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himalayanGeeks.carRental.domain.User;


@Service
@Transactional
public class UserServiceImpl implements com.himalayanGeeks.carRental.service.UserService{

	@Autowired
	com.himalayanGeeks.carRental.repository.UserRepository userRepository;
	

	@Override
	public User save(User user) {
		userRepository.save(user);
		return user;
	}

	

	@Override
	public List<User> findByName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public User findById(int id) {

		return userRepository.findOne(id);
	}



	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}



	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
		
	}



	@Override
	public void edit(User user) {
		

	}



	@Override
	public User findByUsername(String username) {
		return userRepository.findByuserName(username);
	}



	

	

}
