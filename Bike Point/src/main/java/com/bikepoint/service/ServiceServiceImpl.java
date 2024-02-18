package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.ServiceDao;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ServiceDto findServiceById(long id) {
		  com.bikepoint.entites.Service service = serviceDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Service not found"));
		return mapper.map(service, ServiceDto.class);
	}

	
	
	

}
