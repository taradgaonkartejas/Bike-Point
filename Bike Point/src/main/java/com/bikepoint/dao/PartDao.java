package com.bikepoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikepoint.entites.Part;

public interface PartDao extends JpaRepository<Part,Long > {

}
