package com.bikepoint.service;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.CustomerDao;
import com.bikepoint.dto.CustomerDto;
import com.bikepoint.entites.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto addCustomer(CustomerDto customer) {
		Customer cust= mapper.map(customer, Customer.class);
		cust.toString();
		return mapper.map(custDao.save(cust), CustomerDto.class);
	}
	

}
