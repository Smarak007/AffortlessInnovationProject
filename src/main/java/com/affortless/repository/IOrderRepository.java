package com.affortless.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.affortless.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> 
{
	
}
