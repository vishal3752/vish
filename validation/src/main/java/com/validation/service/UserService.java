package com.validation.service;


import java.util.List;
import java.util.Optional;

import com.validation.entity.User;
import com.validation.entity.UserRequest;

import com.validation.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	


	
	@Autowired
	private  UserRepo urp;

	public User saveUser(UserRequest ur)

	{
		
		User u = new User(ur.getUserName(), ur.getUserID(), ur.getEmail(), ur.getMobile(), ur.getAge(), ur.getSex());
		
		
		return urp.save(u);

	}

	public User getUser(int id) throws UserNotFoundException {

		User u=urp.findByUserId(id);
		System.out.println(u);
		if(u==null)
		{
			System.out.println("@@@@@@@@@@@@@@@2vishal");
			throw new UserNotFoundException("user not found "+id);
		}
		else
			return u;
	}

}
