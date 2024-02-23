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
	private double partCost;
	@NotBlank(message = "Company Name is required.")
	private String companyName;
	private long quantity;

}