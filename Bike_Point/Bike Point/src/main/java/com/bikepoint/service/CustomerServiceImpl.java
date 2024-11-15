package com.bikepoint.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.CustomerDao;
import com.bikepoint.dao.ProblemDao;
import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Problem;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private ProblemDao problemDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto addCustomer(CustomerDto customer) {
		Customer cust= mapper.map(customer, Customer.class);
		cust.setPassword(passwordEncoder.encode(customer.getPassword()));
		return mapper.map(custDao.save(cust), CustomerDto.class);
	}

	@Override

	public ProblemDto addProblem(long id, ProblemDto problem) throws ResourceNotFoundException {
		Problem veh= mapper.map(problem, Problem.class);
		veh.setStatus("Initiated");
		Customer cust= custDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Server error"));
		cust.addVehicle(veh);
		Problem savedVehicle=problemDao.save(veh);
		return mapper.map(savedVehicle, ProblemDto.class);
	}

	@Override
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException {
		Customer customer=custDao.findCustomerByEmail(email);
		if (customer != null) {
			customer.setPassword(passwordEncoder.encode(newPassword));
			return "Password changed successfully!";
		} else {
			throw new ResourceNotFoundException("Failed to change password.");
		}
	}


	@Override
	public CustomerDto findCustomer(long id) {
		Customer customer=custDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Server error"));
		return mapper.map(custDao.save(customer), CustomerDto.class);
	}

	@Override
	public List<ProblemDto> findAllProblems(long id) {
		Customer customer=custDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Server error"));
		return customer.getProblems().stream().map(c->mapper.map(c, ProblemDto.class)).collect(Collectors.toList());
	}
	

}
