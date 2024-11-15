package com.bikepoint.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.ProblemDao;
import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Problem;
import com.bikepoint.exception.ResourceNotFoundException;

@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {
	
	@Autowired
	private ProblemDao problemDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto findCustomerbyVehicle(long id) throws ResourceNotFoundException{
		Customer customer=problemDao.findCustomerById(id);
		if (customer!= null) {
			return mapper.map(customer, CustomerDto.class);
		} else {
			throw new ResourceNotFoundException("Failed to load Customer");
		}
		
	}

	@Override
	public List<ProblemDto> findProblemsByStatus(String status) throws ResourceNotFoundException {
		List<Problem> problems=problemDao.findProblemsByStatus(status).orElseThrow(()->new ResourceNotFoundException("Problem not found!"));
		return problems.stream().map(p->mapper.map(p, ProblemDto.class)).collect(Collectors.toList());
	}

	@Override
	public ProblemDto findProblemById(long id)  throws ResourceNotFoundException {
		Problem problem=problemDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Problem not found!"));
		if (problem!= null) {
			return mapper.map(problem, ProblemDto.class);
		} else {
			throw new ResourceNotFoundException("Failed to load Problem");
		}
	}

	

}
