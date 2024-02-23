package com.bikepoint.service;

import com.bikepoint.dto.ServiceDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface ServiceService {
	
	 public ServiceDto addService(ServiceDto service);

	 public ServiceDto findServiceById(long id) throws ResourceNotFoundException;
}
