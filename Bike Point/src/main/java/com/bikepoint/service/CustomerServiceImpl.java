package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.CustomerDao;
import com.bikepoint.dao.VehicleDao;
import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.VehicleDto;
import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Vehicle;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto addCustomer(CustomerDto customer) {
		Customer cust= mapper.map(customer, Customer.class);
		return mapper.map(custDao.save(cust), CustomerDto.class);
	}

	@Override
	public CustomerDto validateCustomer(String email, String password) {
		Customer customer =custDao.findCustomerByEmail(email);
		if (customer==null) {
			throw new ResourceNotFoundException("Invalid Email!");
		}
		if(password.equals(customer.getPassword())) {
			return mapper.map(customer, CustomerDto.class);
		}
		return null;
	}

	@Override
	public VehicleDto addVehicle(long id, VehicleDto vehicle) {
		Vehicle veh= mapper.map(vehicle, Vehicle.class);
		Customer cust= custDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Server error"));
		cust.addVehicle(veh);
		Vehicle savedVehicle=vehicleDao.save(veh);
		return mapper.map(savedVehicle, VehicleDto.class);
	}
	

}
