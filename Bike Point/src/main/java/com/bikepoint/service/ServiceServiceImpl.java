package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.ServiceDao;
@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private ModelMapper mapper;

	
	
	

}
