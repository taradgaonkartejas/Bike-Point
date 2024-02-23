package com.bikepoint.service;

import java.util.List;

import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;
import com.bikepoint.exception.ResourceNotFoundException;


public interface GarageService {

	public GarageDto addGarage(GarageDto garage);
	
	public String removeGarage(Long garageId); 
	
	public List<GarageDto> findAllGarages();
	
	public JobDto addJobInGarage(long garageId,long vehicleId, JobDto job) throws ResourceNotFoundException;
	
	public String removeJobFromGarage (long garageId, long vehicleId, long jobId) throws ResourceNotFoundException;
	
	public GarageDto authenticateGarage(String email,String password) throws ResourceNotFoundException;
	
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException;
}
