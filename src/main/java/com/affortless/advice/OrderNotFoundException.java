package com.affortless.advice;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException
{
	public OrderNotFoundException(String str) 
	{
		super(str);
	}
}
