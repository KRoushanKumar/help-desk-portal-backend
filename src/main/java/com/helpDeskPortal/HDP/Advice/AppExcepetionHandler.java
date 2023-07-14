package com.helpDeskPortal.HDP.Advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.helpDeskPortal.HDP.Exception.UserAllreadyFoundException;

@RestControllerAdvice
public class AppExcepetionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserAllreadyFoundException.class)
	public Map<String,String> HandleBusinessException(UserAllreadyFoundException ex)
	{
		Map<String,String> errorMap = new HashMap<String,String>();
		
		errorMap.put("ErrorMessage", ex.getMessage());
		
		return errorMap;
		
	}
	
}
