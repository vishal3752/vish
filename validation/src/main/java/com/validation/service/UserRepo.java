package com.validation.service;


import com.validation.entity.User;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	User findByUserId(int id);

	//User findByUserId();
	
	//public User findByUserId(int id);

}
