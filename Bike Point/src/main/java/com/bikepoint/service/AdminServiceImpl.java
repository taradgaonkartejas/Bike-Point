package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.AdminDao;
import com.bikepoint.dto.AdminDto;
import com.bikepoint.entites.Admin;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public AdminDto validateAdmin(String email, String password) {
		Admin admin =adminDao.findAdminByEmail(email);
		if (admin==null) {
			throw new ResourceNotFoundException("Invalid Email!");
		}
		if(password.equals(admin.getPassword())) {
			return mapper.map(admin, AdminDto.class);
		}
		return null;
	}
	
	

}
