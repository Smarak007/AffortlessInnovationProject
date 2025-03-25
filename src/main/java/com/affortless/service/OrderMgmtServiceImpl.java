package com.affortless.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.affortless.advice.InvalidStatusChangingException;
import com.affortless.advice.OrderNotFoundException;
import com.affortless.entity.Order;
import com.affortless.entity.OrderStatus;
import com.affortless.repository.IOrderRepository;

import jakarta.validation.Valid;
@Service
public class OrderMgmtServiceImpl implements IOrderManagementService 
{
	@Autowired
	private IOrderRepository orderRepo;

	@Override
	public Order createOrder(@Valid Order order) 
	{
		order.setStatus(OrderStatus.PENDING);
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrder()
	{
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(Integer id) 
	{
		return orderRepo.findById(id).orElseThrow(()->new OrderNotFoundException("OrderId not found"));
	}

	@Override
	public String checkOrderStatus(Integer id,OrderStatus newStatus)throws Exception   
	{
		Optional<Order> opt = orderRepo.findById(id);
		if(opt.isPresent())
		{
			Order order = opt.get();
			if(!OrderStatus.isAuthenticateTransaction(order.getStatus(), newStatus))
			{
				throw new InvalidStatusChangingException("Invalid Status");
			}
			else
			{
				order.setStatus(newStatus);
				orderRepo.save(order);
			}
			return "Order status changed and the current status is: " + order.getStatus();
		}
		return "Order ID not found";
	}

	@Override
	public void removeOrderById(Integer id)  
	{
		orderRepo.deleteById(id);
	}

}
