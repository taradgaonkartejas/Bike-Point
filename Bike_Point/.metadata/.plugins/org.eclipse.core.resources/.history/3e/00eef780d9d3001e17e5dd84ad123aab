package com.bikepoint.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PartDatabaseDto {
	@ReadOnlyProperty
	private int id;
	@NotBlank(message = "Part name is required.")
	private String partName;
	private double partCost;
	@NotBlank(message = "Company Name is required.")
	private String companyName;

}
