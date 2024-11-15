package com.bikepoint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikepoint.dto.ApiResponse;
import com.bikepoint.dto.PartDto;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.service.JobService;

@RestController
@Validated
@RequestMapping("/job")
@CrossOrigin(origins = "*")
public class JobController {
	
	@Autowired
	private JobService jobSer;
	
	@PutMapping("addpart/{partId}/{quantity}/{jobId}")
	public ResponseEntity<?> addPartInJob(@PathVariable long partId, @PathVariable long quantity,@PathVariable long jobId ){
		PartDto part= jobSer.addPartInJob(partId,quantity, jobId);
		if (part != null) {
			return new ResponseEntity<PartDto>(part, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to add part in job."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("addservice/{serviceId}/{jobId}")
	public ResponseEntity<?> addServiceInJob(@PathVariable long serviceId, @PathVariable long jobId){
		ServiceDto service= jobSer.addServiceInJob(serviceId, jobId);
		if (service != null) {
			return new ResponseEntity<ServiceDto>(service, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to add service in job."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("removepart/{partId}/{jobId}")
	public ResponseEntity<?> removePartFromJob(@PathVariable long partId, @PathVariable long jobId){
		String message=jobSer.removePartFromJob(partId, jobId);
		if (message != null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(message), HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to remove part in job."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("removeservice/{serviceId}/{jobId}")
	public ResponseEntity<?> removeServiceFromJob(@PathVariable long serviceId, @PathVariable long jobId){
		String message=jobSer.removeServiceFromJob(serviceId, jobId);
		if (message != null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(message), HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to remove service in job."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
