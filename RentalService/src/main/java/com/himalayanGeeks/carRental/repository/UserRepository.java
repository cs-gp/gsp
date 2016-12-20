package com.himalayanGeeks.carRental.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.himalayanGeeks.carRental.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByuserName(String username);
	
	
	
}
