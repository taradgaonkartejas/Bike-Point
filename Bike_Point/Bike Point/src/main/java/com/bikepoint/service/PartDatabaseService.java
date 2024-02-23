package com.bikepoint.service;

import com.bikepoint.dto.PartDatabaseDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface PartDatabaseService {

 public PartDatabaseDto addPart(PartDatabaseDto part);
 
 public PartDatabaseDto findPartById(long id) throws ResourceNotFoundException;
}
