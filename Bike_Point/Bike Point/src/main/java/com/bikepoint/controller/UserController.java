package com.bikepoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikepoint.config.security.JwtAuthResponce;
import com.bikepoint.config.security.JwtTokenHelper;
import com.bikepoint.dto.LoginRequest;

@RestController
@Validated
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

//	@Autowired
//	private UserService userSer;

//	@PostMapping("/login")
//	public ResponseEntity<?> validateUser(@RequestBody @Valid LoginRequest user)throws ResourceNotFoundException{
//		LoginResponse validatedUser=userSer.authoriseUser(user.getEmail(), user.getPassword());
//		return new ResponseEntity<LoginResponse>(validatedUser,HttpStatus.OK);
//	}

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponce> createToken(@RequestBody @Valid LoginRequest request) {

		authenticate(request.getEmail(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		
		String token = jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponce responce= new JwtAuthResponce();
		responce.setToken(token);
		return new ResponseEntity<JwtAuthResponce>(responce,HttpStatus.OK);
	}

	private void authenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,
				password);

		authManager.authenticate(authenticationToken);
	}

}
