package com.bikepoint.service;

import com.bikepoint.exception.ResourceNotFoundException;

public interface AdminService {

	String forgotPassword(String email, String newPassword) throws ResourceNotFoundException;
}
