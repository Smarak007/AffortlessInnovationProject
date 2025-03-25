package com.affortless.service;

import java.util.List;

import com.affortless.entity.Order;
import com.affortless.entity.OrderStatus;

import jakarta.validation.Valid;

public interface IOrderManagementService 
{
	public Order createOrder(@Valid Order order);
	public List<Order> getAllOrder();
	public Order getOrderById(Integer id);
	public String checkOrderStatus(Integer id,OrderStatus newStatus)throws Exception;
	public void removeOrderById(Integer id);
}
