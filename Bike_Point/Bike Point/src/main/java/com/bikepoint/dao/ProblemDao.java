package com.bikepoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Problem;
import java.util.List;
import java.util.Optional;

public interface ProblemDao extends JpaRepository<Problem,Long > {

	public Customer findCustomerById(long id);

	public Optional<List<Problem>> findProblemsByStatus(String status);
}
