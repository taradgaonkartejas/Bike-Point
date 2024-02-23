package com.bikepoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Problem;

public interface ProblemDao extends JpaRepository<Problem,Long > {

	public Customer findCustomerById(long id);
}
