package com.bikepoint.service;

import com.bikepoint.dto.LoginResponse;
import com.bikepoint.exception.ResourceNotFoundException;

public interface UserService {
	
	public LoginResponse authoriseUser(String email, String password) throws ResourceNotFoundException;
	
	public LoginResponse getUserByEmail(String email)throws ResourceNotFoundException;
}
