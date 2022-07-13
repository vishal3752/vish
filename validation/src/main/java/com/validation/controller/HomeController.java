package com.validation.controller;



import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.validation.entity.User;
import com.validation.entity.UserRequest;
import com.validation.exception.UserNotFoundException;
import com.validation.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class HomeController {
	@Autowired
	private UserService userservice;

	
	@GetMapping("{value}")
	public User getUser(@PathVariable("value") @NotNull @Max(1000) int  id) throws UserNotFoundException
	{
		return userservice.getUser(id);
	}
	@PostMapping("/singup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest ur)
	{
		
	
		return new ResponseEntity<>(userservice.saveUser(ur),HttpStatus.CREATED);
		
	}

}
