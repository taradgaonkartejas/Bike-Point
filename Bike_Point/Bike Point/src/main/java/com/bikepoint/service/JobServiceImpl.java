package com.bikepoint.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.JobDao;
import com.bikepoint.dao.PartDao;
import com.bikepoint.dao.PartDatabaseDao;
import com.bikepoint.dao.ProblemDao;
import com.bikepoint.dao.ServiceDao;
import com.bikepoint.dto.BillDto;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;
import com.bikepoint.dto.PartDto;
import com.bikepoint.dto.PriceDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.entites.Customer;
import com.bikepoint.entites.Garage;
import com.bikepoint.entites.Job;
import com.bikepoint.entites.Part;
import com.bikepoint.entites.PartDatabase;
import com.bikepoint.entites.Problem;
import com.bikepoint.exception.ResourceNotFoundException;
@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private PartDatabaseDao partDatabaseDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private ProblemDao problemDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public JobDto findJobById(long id) throws ResourceNotFoundException {
		Job job=jobDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		return mapper.map(job, JobDto.class);
	}

	@Override
	public PartDto addPartInJob(long partId, long quantity, long jobId) throws ResourceNotFoundException {
		Job job =jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		PartDatabase partData=partDatabaseDao.findById(partId).orElseThrow(()->new ResourceNotFoundException("Part not found"));
		Part part=new Part();
		part.setPartName(partData.getPartName());
		part.setCompanyName(partData.getCompanyName());
		part.setPartCost(partData.getPartCost());
		part.setQuantity(quantity);
		partDao.save(part);
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

	@Override
	public BillDto generateBill(long jobId) throws ResourceNotFoundException {
		Job job= jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		Problem problem=job.getProblem();
		Garage garage=job.getGarage();
		Customer customer=problem.getCustomer();
		List<PriceDto> desc= new ArrayList<>();
		job.getServices().stream().forEach(s->desc.add(new PriceDto(s.getServiceName(), 1, s.getServiceCost())));
		job.getParts().stream().forEach(s->desc.add(new PriceDto(s.getPartName(), s.getQuantity(), s.getPartCost())));
		BillDto bill= new BillDto(customer.getId(), customer.getFirstName()+" "+customer.getLastName(), jobId, garage.getId(), desc); 
		double totalPrice=0;
		for (PriceDto priceDto : desc) {
			totalPrice+=priceDto.getTotalPrice();
		}
		bill.setTotalPrice(totalPrice);
		return bill;
	}

	@Override
	public ProblemDto findProblemByJob(long jobId) throws ResourceNotFoundException{
		Job job= jobDao.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job not found"));
		return mapper.map(job.getProblem(), ProblemDto.class);
	}

	@Override
	public GarageDto findGarageByProblem(long id) throws ResourceNotFoundException {
		Problem problem= problemDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Problem not found"));
		Garage garage=problem.getJobs().get(0).getGarage();
		return mapper.map(garage, GarageDto.class);
	}
	
	

}
