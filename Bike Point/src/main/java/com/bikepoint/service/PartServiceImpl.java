package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.PartDao;
@Service
@Transactional
public class PartServiceImpl implements PartService {
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private ModelMapper mapper;

	
	
	

}
