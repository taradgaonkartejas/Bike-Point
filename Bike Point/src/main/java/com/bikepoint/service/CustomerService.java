package com.bikepoint.service;


import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.VehicleDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface CustomerService {

	public CustomerDto addCustomer(CustomerDto customer);
	
	public CustomerDto validateCustomer(String email, String password);
	
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException;
	
	public VehicleDto addVehicle(long id, VehicleDto vehicle) throws ResourceNotFoundException;
}
