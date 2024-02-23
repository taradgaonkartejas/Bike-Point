package com.bikepoint.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.GarageDao;
import com.bikepoint.dao.JobDao;
import com.bikepoint.dao.ProblemDao;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;
import com.bikepoint.entites.Garage;
import com.bikepoint.entites.Job;
import com.bikepoint.entites.Problem;
import com.bikepoint.exception.ResourceNotFoundException;

@Service
@Transactional
public class GarageServiceImpl implements GarageService {

	@Autowired
	private GarageDao garageDao;
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private ProblemDao problemDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public GarageDto addGarage(GarageDto garage) {
		Garage gar = mapper.map(garage, Garage.class);
		return mapper.map(garageDao.save(gar), GarageDto.class);
	}

	@Override
	public String removeGarage(Long garageId) {
		garageDao.deleteById(garageId);
		return "Garage removed successfully";
	}

	@Override
	public List<GarageDto> findAllGarages() {
		return garageDao.findAll().stream().map(s-> mapper.map(s, GarageDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public JobDto addJobInGarage(long garageId,long vehicleId, JobDto job) throws ResourceNotFoundException{
		Job oldjob=mapper.map(job, Job.class);
		Job savedJob=jobDao.save(oldjob);
		Garage garage=garageDao.findById(garageId).orElseThrow(()->new ResourceNotFoundException("Garage not found"));
		Problem problem=problemDao.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle not found"));
		garage.addJob(savedJob);
		problem.addJob(savedJob);
		Job newJob=jobDao.save(savedJob);
		problemDao.save(problem);
		return mapper.map(newJob, JobDto.class);
	}

	@Override
	public String removeJobFromGarage(long garageId, long vehicleId, long jobId) throws ResourceNotFoundException{
		Job job=jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		Problem problem=problemDao.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle not found"));
		Garage garage=garageDao.findById(garageId).orElseThrow(()->new ResourceNotFoundException("Garage not found"));
		problem.removeJob(job);
		garage.removeJob(job);
		jobDao.delete(job);
		return "Canceled job sucessfully!";
	}

	
	@Override
	public String forgotPassword(String email, String newPassword) throws ResourceNotFoundException {
		Garage garage=garageDao.findGarageByEmail(email);
		if (garage != null) {
			garage.setPassword(newPassword);
			return "Password changed successfully!";
		} else {
			throw new ResourceNotFoundException("Failed to change password.");
		}
	}

}