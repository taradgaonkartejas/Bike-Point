package com.bikepoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikepoint.dto.LoginRequest;
import com.bikepoint.dto.LoginResponse;
import com.bikepoint.exception.ResourceNotFoundException;
import com.bikepoint.service.UserService;

@RestController
@Validated
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userSer;
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody @Valid LoginRequest user)throws ResourceNotFoundException{
		LoginResponse validatedUser=userSer.authoriseUser(user.getEmail(), user.getPassword());
		return new ResponseEntity<LoginResponse>(validatedUser,HttpStatus.OK);
	}
}
