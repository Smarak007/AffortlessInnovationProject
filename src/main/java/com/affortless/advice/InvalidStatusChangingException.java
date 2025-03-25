package com.affortless.advice;

@SuppressWarnings("serial")
public class InvalidStatusChangingException extends Exception 
{
	public InvalidStatusChangingException(String str) 
	{
		super(str);
	}
}
