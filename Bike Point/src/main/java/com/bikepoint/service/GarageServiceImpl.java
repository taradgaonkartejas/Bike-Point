package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.GarageDao;
@Service
@Transactional
public class GarageServiceImpl implements AdminService {
	
	@Autowired
	private GarageDao garageDao;
	
	@Autowired
	private ModelMapper mapper;

	
	
	

}
