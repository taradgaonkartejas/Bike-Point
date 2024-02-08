package com.bikepoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Job;

public interface VehicleDao extends JpaRepository<Job,Long > {

}
