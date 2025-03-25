package com.affortless.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.affortless.entity.Order;
import com.affortless.entity.OrderStatus;
import com.affortless.service.IOrderManagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderOperationRestControllerAPI 
{
	@Autowired
	private IOrderManagementService service;
	
	@PostMapping("/create")
	public ResponseEntity<String>generateOrder(@RequestBody @Valid Order order)
	{
		Integer id = service.createOrder(order).getOrderId();
		return new ResponseEntity<String>("Order created successfully having orderId: " + id +
											" and order status is : " + order.getStatus(),HttpStatus.CREATED);
	}
	@GetMapping("/showAll")
	public ResponseEntity<List<Order>> showAllOrders()
	{
		return new ResponseEntity<List<Order>>(service.getAllOrder(),HttpStatus.OK);
	}
	@GetMapping("/show/{id}")
	public ResponseEntity<Order> showOrderById(@PathVariable Integer id)
	{
		return new ResponseEntity<Order>(service.getOrderById(id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable Integer id)
	{
		service.removeOrderById(id);
		return new ResponseEntity<String>("Order deleted having order id : " + id,HttpStatus.OK);
	}
	@PutMapping("/update/{id}/status")
	public ResponseEntity<String>updateOrderStatus(@PathVariable Integer id,@RequestParam OrderStatus status)throws Exception 
	{
		String msg = service.checkOrderStatus(id, status);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
