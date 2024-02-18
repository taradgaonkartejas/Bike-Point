package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.JobDao;
import com.bikepoint.dto.JobDto;
import com.bikepoint.entites.Job;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public JobDto findJobById(long id) {
		Job job=jobDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		return mapper.map(job, JobDto.class);
	}

	
	
	

}
