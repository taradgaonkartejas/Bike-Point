package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.JobDao;
import com.bikepoint.dao.PartDao;
import com.bikepoint.dao.ServiceDao;
import com.bikepoint.dto.JobDto;
import com.bikepoint.dto.PartDto;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.entites.Job;
import com.bikepoint.entites.Part;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public JobDto findJobById(long id) throws ResourceNotFoundException {
		Job job=jobDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		return mapper.map(job, JobDto.class);
	}

	@Override
	public PartDto addPartInJob(long partId, long jobId) throws ResourceNotFoundException {
		Job job =jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		Part part=partDao.findById(partId).orElseThrow(()->new ResourceNotFoundException("Part not found"));
		job.addPart(part);
		jobDao.save(job);
		Part savedPart=partDao.save(part);
		return mapper.map(savedPart, PartDto.class);
	}

	@Override
	public ServiceDto addServiceInJob(long serviceId, long jobId) throws ResourceNotFoundException{
		Job job =jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		com.bikepoint.entites.Service service=serviceDao.findById(serviceId).orElseThrow(()->new ResourceNotFoundException("Service not found"));
		job.addService(service);
		jobDao.save(job);
		com.bikepoint.entites.Service savedService=serviceDao.save(service);
		return mapper.map(savedService, ServiceDto.class);
	}

	@Override
	public String removePartFromJob(long partId, long jobId) throws ResourceNotFoundException{
		Job job =jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		Part part=partDao.findById(partId).orElseThrow(()->new ResourceNotFoundException("Part not found"));
		job.removePart(part);
		jobDao.save(job);
		return "part removed form job";
	}

	@Override
	public String removeServiceFromJob(long serviceId, long jobId) throws ResourceNotFoundException{
		Job job =jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		com.bikepoint.entites.Service service=serviceDao.findById(serviceId).orElseThrow(()->new ResourceNotFoundException("Service not found"));
		job.removeService(service);
		jobDao.save(job);
		return "Service removed form job";
	}

	
	
	

}
