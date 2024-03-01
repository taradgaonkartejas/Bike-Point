package com.bikepoint.service;

import com.bikepoint.dto.BillDto;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;
import com.bikepoint.dto.PartDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.exception.ResourceNotFoundException;

public interface JobService {

	public JobDto findJobById(long id) throws ResourceNotFoundException;
	
	public PartDto addPartInJob(long partId, long quantity, long jobId) throws ResourceNotFoundException;
	
	public ServiceDto addServiceInJob(long serviceId, long jobId) throws ResourceNotFoundException;
	
    public String removePartFromJob(long partId, long jobId) throws ResourceNotFoundException;
	
	public String removeServiceFromJob(long serviceId, long jobId) throws ResourceNotFoundException;
	
	public BillDto generateBill(long jobId) throws ResourceNotFoundException;

	public ProblemDto findProblemByJob(long jobId) throws ResourceNotFoundException;

	public GarageDto findGarageByProblem(long id) throws ResourceNotFoundException;
	
}
