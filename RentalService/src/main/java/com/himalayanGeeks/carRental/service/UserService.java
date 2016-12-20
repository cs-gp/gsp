package com.himalayanGeeks.carRental.service;


import java.util.List;




import com.himalayanGeeks.carRental.domain.User;


public interface UserService {
	
	public User save(User user);
	public List<User> findByName(String firstName);
	public List<User> getAll();
	void delete(Integer id);
	User findById(int id);
	public void edit(User user);
	User findByUsername(String username);
	
