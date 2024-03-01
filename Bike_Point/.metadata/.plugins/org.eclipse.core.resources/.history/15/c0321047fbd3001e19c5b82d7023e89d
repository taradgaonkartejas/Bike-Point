package com.bikepoint.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ServiceDto {
	@ReadOnlyProperty
	private int id;
	@NotBlank(message = "Service name cannot be blank.")
	private String serviceName;
	@Min(value = 1, message = "Service cost cannot be blank")
	private double serviceCost;

}
