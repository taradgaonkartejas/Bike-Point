package com.bikepoint.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.ReadOnlyProperty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDto {
	@ReadOnlyProperty
	private int id;
	@Email(message = "Please enter valid email.")
	private String email;
	@JsonFormat(pattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" )
	// Minimum eight characters, at least one uppercase letter, one lowercase
	// letter, one number and one special character
	private String password;
	@NotNull(message = "First name cannot be blank.")
	private String firstName;
	@NotNull(message = "Last name cannot be blank.")
	private String lastName;
	@NotNull(message = "Address cannot be blank.")
	private String address;
	@JsonFormat(pattern = "^.*[0-9]{10}")
	private long mobileNo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;

}
