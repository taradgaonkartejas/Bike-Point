package com.bikepoint.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GarageDto {
	@ReadOnlyProperty
	private int id;
	@Email(message = "Please enter valid email.")
	private String email;
	@JsonFormat(pattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" )
	// Minimum eight characters, at least one uppercase letter, one lowercase
	// letter, one number and one special character
	private String password;
	@NotNull(message = "Address cannot be blank.")
	private String address;
	private double longitude;
    private double latitude;
	@JsonFormat(pattern = "^.*[0-9]{10}")
	private long mobileNo;


}
