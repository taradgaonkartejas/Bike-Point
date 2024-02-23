package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.ProblemDao;
import com.bikepoint.dto.CustomerDto;
import com.bikepoint.entites.Customer;
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

	
	
	

}
