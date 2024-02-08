package com.bikepoint.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.bikepoint.entites.ProblemType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PartDto {
	@ReadOnlyProperty
	private int id;
	@NotBlank(message = "Part name is required.")
	private String partName;
	@NotBlank(message = "Part Cost is required.")
	private double partCost;
	
	private String companyName;
	@NotBlank(message = "Quantity is required.")
	private long quantity;

}
