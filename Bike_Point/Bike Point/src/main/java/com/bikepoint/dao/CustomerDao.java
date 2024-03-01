package com.bikepoint.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Customer;

public interface CustomerDao extends JpaRepository<Customer,Long > {

	public Customer findCustomerByEmail(String email);
}
