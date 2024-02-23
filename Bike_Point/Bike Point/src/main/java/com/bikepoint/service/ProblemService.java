package com.bikepoint.service;

import com.bikepoint.dto.CustomerDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface ProblemService {

	public CustomerDto findCustomerbyVehicle(long id) throws ResourceNotFoundException;
}
