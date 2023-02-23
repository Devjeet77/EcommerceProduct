package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prodId;
	@NotNull(message = "Name should not be null")
	private String name;
	@NotNull(message = "Price should not be null")
	private Long price;
	private String details;
	private String image;
	private String category;
	private Double rating;
	private Long stock;
}
