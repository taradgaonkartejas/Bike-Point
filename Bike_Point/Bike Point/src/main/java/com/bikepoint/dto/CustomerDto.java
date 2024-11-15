package com.bikepoint.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CustomerDto {
	@ReadOnlyProperty
	private int id;
	@Email(message = "Please enter valid email.")
	@NotEmpty
	private String email;
	 @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
	            message = "password must contain atleast 8 characters 1 uppercase, 1 lowercase, 1 special character and 1 digit.")
	private String password;
	@NotBlank(message = "First name cannot be blank.")
	private String firstName;
	@NotBlank(message = "Last name cannot be blank.")
	private String lastName;
	@Pattern(regexp = "^.{10,150}$",
    message = "Address should contain 10 to 150 charactors.")
	private String address;
	@Pattern(regexp="^\\d{10}$", message = "Please enter valid mobile no.")
	private String mobileNo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;

}
