package com.bikepoint.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDto {
	@ReadOnlyProperty
	private int id;
	@Email(message = "Please enter valid email.")
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "password must contain atleast 8 characters 1 uppercase, 1 lowercase, 1 special character and 1 digit")
	private String password;

}
