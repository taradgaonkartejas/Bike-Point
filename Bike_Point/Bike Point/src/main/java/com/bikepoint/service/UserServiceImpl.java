package com.bikepoint.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.AdminDao;
import com.bikepoint.dao.CustomerDao;
import com.bikepoint.dao.GarageDao;
import com.bikepoint.dto.LoginResponse;
import com.bikepoint.entites.Admin;
import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Garage;
import com.bikepoint.exception.ResourceNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private GarageDao garageDao;

	@Override
	public LoginResponse authoriseUser(String email, String password)throws ResourceNotFoundException {
		Customer customer= custDao.findCustomerByEmail(email);
		if(customer!=null) {
			if (customer.getPassword().equals(password)) {
				return new LoginResponse(customer.getId(), email, customer.getPassword(), "customer");
			}else {
				throw new ResourceNotFoundException("Invalid Password");
			}
		}
		Garage garage= garageDao.findGarageByEmail(email);
		if(garage!=null) {
			if (garage.getPassword().equals(password)) {
				return new LoginResponse(garage.getId(), email, garage.getPassword(), "garage");
			}else {
				throw new ResourceNotFoundException("Invalid Password");
			}
		}
		Admin admin= adminDao.findAdminByEmail(email);
		if(admin!=null) {
			if (admin.getPassword().equals(password)) {
				return new LoginResponse(admin.getId(), email, admin.getPassword(), "admin");
			}else {
				throw new ResourceNotFoundException("Invalid Password");
			}
		}
		throw new ResourceNotFoundException("User not found.");
	}
	
	public LoginResponse getUserByEmail(String email)throws ResourceNotFoundException {
		Customer customer= custDao.findCustomerByEmail(email);
		if(customer!=null) {
			return new LoginResponse(customer.getId(), email, customer.getPassword(), "customer");
		}
		Garage garage= garageDao.findGarageByEmail(email);
		if(garage!=null) {
			return new LoginResponse(garage.getId(), email, garage.getPassword(), "garage");
		}
		Admin admin= adminDao.findAdminByEmail(email);
		if(admin!=null) {
			return new LoginResponse(admin.getId(), email, admin.getPassword(), "admin");
		}
		throw new ResourceNotFoundException("Invalid username or password!");
	}

}
