package com.bikepoint.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GarageDto {
	@ReadOnlyProperty
	private int id;
	@Email(message = "Please enter valid email.")
	@NotEmpty
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "password must contain atleast 8 characters 1 uppercase, 1 lowercase, 1 special character and 1 digit")
	private String password;
	@NotBlank(message = "Garage Name cannot be blank.")
	private String garageName;
	@Pattern(regexp = "^.{10,150}$",
		    message = "Address should contain 10 to 150 charactors.")
	private String address;
	private double longitude;
    private double latitude;
    @Pattern(regexp="^\\d{10}$", message = "Please enter valid mobile no.")
	private String mobileNo;


}
