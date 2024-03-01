package com.bikepoint.config.security;


import com.bikepoint.dto.LoginResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthResponce {

	
	private String token;

	
	private LoginResponse user;
}
