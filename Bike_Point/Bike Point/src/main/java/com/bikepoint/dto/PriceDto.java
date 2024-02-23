package com.bikepoint.dto;


import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDto {
	
	private String description;
	@Value(value = "1")
	private long quantity;
	private double price;
	private double totalPrice;
	
	
	public PriceDto(String description, long quantity, double price) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = quantity*price;
	}


	@Override
	public String toString() {
		return "PriceDto [description=" + description + ", quantity=" + quantity + ", price=" + price + ", totalPrice="
				+ totalPrice + "]";
	}


	
	
	

}
