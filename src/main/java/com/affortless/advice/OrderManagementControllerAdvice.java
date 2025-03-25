package com.affortless.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderManagementControllerAdvice 
{
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<String>handelAllException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(exception = OrderNotFoundException.class)
	public ResponseEntity<String>handleOrderNotFoundException(OrderNotFoundException onfe)
	{
		return new ResponseEntity<String>(onfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
