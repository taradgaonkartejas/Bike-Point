package com.bikepoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle,Long > {

}
