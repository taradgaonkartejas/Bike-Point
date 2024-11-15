package com.bikepoint.service;


import java.util.List;

import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.exception.ResourceNotFoundException;


public interface CustomerService {

	public CustomerDto addCustomer(CustomerDto customer);
	

	public CustomerDto findCustomer(long id);
	
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException;
	
	public ProblemDto addProblem(long id, ProblemDto problem) throws ResourceNotFoundException;
	
	public List<ProblemDto> findAllProblems(long id);
}
