package com.bikepoint.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.AdminDao;
import com.bikepoint.entites.Admin;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException {
		Admin admin=adminDao.findAdminByEmail(email);
		if (admin != null) {
			admin.setPassword(newPassword);
			return "Password changed successfully!";
		} else {
			throw new ResourceNotFoundException("Failed to change password.");
		}
	}
	

}
