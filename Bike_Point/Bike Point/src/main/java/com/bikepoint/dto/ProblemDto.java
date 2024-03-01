package com.bikepoint.dto;


import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ProblemDto {
	@ReadOnlyProperty
	private int id;
	@NotBlank(message = "Vehicle company cannot be blank.")
	private String vehicleCompany;
	@NotBlank(message = "Vehicle Mode cannot be blank.")
	private String vehicleModel;
	@NotBlank(message = "Problem type cannot be blank.")
	private String problemType;
	@NotBlank(message = "Problem description cannot be blank.")
	private String problemDescription;
	private String address;
	private double longitude;
    private double latitude;
	@ReadOnlyProperty
	String status;


}
