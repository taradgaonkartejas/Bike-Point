package com.bikepoint.service;

import java.util.List;

import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface ProblemService {

	public CustomerDto findCustomerbyVehicle(long id) throws ResourceNotFoundException;
	
	public List<ProblemDto> findProblemsByStatus(String status) throws ResourceNotFoundException;
	
	public ProblemDto findProblemById(long id)  throws ResourceNotFoundException ;
}
