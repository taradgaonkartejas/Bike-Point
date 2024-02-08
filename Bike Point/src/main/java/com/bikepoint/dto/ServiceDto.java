package com.bikepoint.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.bikepoint.entites.ProblemType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ServiceDto {
	@ReadOnlyProperty
	private int id;
	@NotBlank(message = "Service name cannot be blank.")
	private String serviceType;
	@NotBlank(message = "Cost cannot be blank.")
	private double serviceCost;

}
