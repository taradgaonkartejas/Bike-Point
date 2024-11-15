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
	public ServiceDto findServiceById(long id) throws ResourceNotFoundException{
		  com.bikepoint.entites.Service service = serviceDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Service not found"));
		return mapper.map(service, ServiceDto.class);
	}

	@Override
	public ServiceDto addService(ServiceDto service) {
		com.bikepoint.entites.Service ser=mapper.map(service, com.bikepoint.entites.Service.class);
		return mapper.map(serviceDao.save(ser), ServiceDto.class);
	}

	
	
	

}
