package com.bikepoint.service;

import java.util.List;

import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;


public interface GarageService {

	public GarageDto addGarage(GarageDto garage);
	
	public String removeGarage(Long garageId); 
	
	public List<GarageDto> findAllGarages();
	
	public JobDto addJobInGarage(long garageId, JobDto job);
	
	public String removeJobFromGarage (long garageId, long jobId);
}
