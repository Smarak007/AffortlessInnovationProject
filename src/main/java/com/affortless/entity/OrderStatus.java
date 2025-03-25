package com.affortless.entity;

public enum OrderStatus 
{
	PENDING, CONFIRMED, SHIPPED, DELIVERED;
	
	
	public static boolean isAuthenticateTransaction(OrderStatus current,OrderStatus next)
	{
		switch(current)
		{
		case PENDING:
			return next==CONFIRMED;
		case CONFIRMED:
			return next==SHIPPED;
		case SHIPPED:
			return next==DELIVERED;
		default :
			return false;
		}
	}
}
