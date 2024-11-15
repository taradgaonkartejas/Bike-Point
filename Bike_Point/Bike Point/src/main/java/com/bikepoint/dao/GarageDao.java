package com.bikepoint.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Garage;

public interface GarageDao extends JpaRepository<Garage,Long > {

	public Garage findGarageByEmail(String email);
	
}
