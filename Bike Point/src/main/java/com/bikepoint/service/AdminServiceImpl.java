package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.AdminDao;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao custDao;
	
	@Autowired
	private ModelMapper mapper;

	
	
	

}
