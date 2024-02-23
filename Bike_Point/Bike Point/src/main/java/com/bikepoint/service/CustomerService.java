package com.bikepoint.service;


import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface CustomerService {

	public CustomerDto addCustomer(CustomerDto customer);
	
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException;
	
	public ProblemDto addVehicle(long id, ProblemDto vehicle) throws ResourceNotFoundException;
}