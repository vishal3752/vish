package com.validation.exceptionhander;

import java.util.HashMap;
import java.util.Map;

import com.validation.exception.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHander {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String ,String > handleInvalidArgument(MethodArgumentNotValidException ex)
	{
		
		Map<String ,String> map=new HashMap<String ,String >();
		ex.getBindingResult().getFieldErrors().forEach(e->{
		
			map.put(e.getField(), e.getDefaultMessage());
		});
		
		return map;
		
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String ,String> Usernotfoundexception(UserNotFoundException ex)
	{
		Map<String ,String>  error=new HashMap<>();
		error.put("error-massage", ex.getMessage());
		return error;
	}

}
