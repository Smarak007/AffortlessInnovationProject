package com.affortless.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="OrderProcessing_Info")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order 
{
	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "ORDERID_SEQ",initialValue = 2345,allocationSize = 25)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer orderId;
	
	
	@NotNull(message = "UserId can't be null")
	private Long userId;
	
	
	@NotEmpty(message = "items can't be empty")
	private List<String> items;
	
	
	@NotNull(message = "Total price can't be null")
	@Min(value = 1,message = "Price must be greater than zero")
	private Double totalPrice;
	
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
}
