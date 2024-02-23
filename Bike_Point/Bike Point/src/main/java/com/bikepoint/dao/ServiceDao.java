package com.bikepoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Service;

public interface ServiceDao extends JpaRepository<Service,Long > {

}
