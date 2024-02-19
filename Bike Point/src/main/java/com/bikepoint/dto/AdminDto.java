package com.bikepoint.dto;


import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.ReadOnlyProperty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDto {
	@ReadOnlyProperty
	private int id;
	@Email(message = "Please enter valid email.")
	private String email;
	@JsonFormat(pattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" )
	// Minimum eight characters, at least one uppercase letter, one lowercase
	// letter, one number and one special character
	private String password;

}
