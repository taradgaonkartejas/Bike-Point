package com.bikepoint.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.GarageDao;
import com.bikepoint.dao.JobDao;
import com.bikepoint.dao.PartDao;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;
import com.bikepoint.entites.Garage;
import com.bikepoint.entites.Job;
import com.bikepoint.entites.Part;
import com.bikepoint.exception.ResourceNotFoundException;

@Service
@Transactional
public class GarageServiceImpl implements GarageService {

	@Autowired
	private GarageDao garageDao;
	
	@Autowired
	private JobDao jobDao;

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
	public JobDto addJobInGarage(long garageId, JobDto job) {
		Job newjob=mapper.map(job, Job.class);
		
		Garage garage=garageDao.findById(garageId).orElseThrow(()->new ResourceNotFoundException("Garage not found"));
		garage.addJob(newjob);
		Job savedJob=jobDao.save(newjob);
		return mapper.map(savedJob, JobDto.class);
	}

	@Override
	public String removeJobFromGarage(long garageId, long jobId) {
		Job job=jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		Garage garage=garageDao.findById(garageId).orElseThrow(()->new ResourceNotFoundException("Garage not found"));
		garage.removeJob(job);
		jobDao.delete(job);
		return "Canceled job sucessfully!";
	}

}
