package com.bikepoint.controller;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikepoint.dto.ApiResponse;
import com.bikepoint.dto.BillDto;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.JobDto;
import com.bikepoint.dto.PartDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.service.GarageService;
import com.bikepoint.service.JobService;
import com.bikepoint.service.PartService;

import com.bikepoint.service.ProblemService;
import com.bikepoint.service.ServiceService;

@RestController
@Validated
@RequestMapping("/garage")
@CrossOrigin(origins = "http://localhost:3000")
public class GarageController {

	@Autowired
	private GarageService garageSer;

	@Autowired
	private PartService partSer;

	@Autowired
	private ServiceService serviceSer;

	@Autowired
	private JobService jobSer;
	
	@Autowired
	private ProblemService problemSer;

	@PostMapping("getgarage/{id}")
	public ResponseEntity<?> findGarageById(@PathVariable long id){
		GarageDto garage=garageSer.findGarageById(id);
		if (garage != null) {
			return new ResponseEntity<GarageDto>(garage, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get garage."),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addjob/{garageId}/{problemId}")
	public ResponseEntity<?> addJob(@PathVariable long garageId,@PathVariable long problemId, @RequestBody @Valid JobDto job) {
		JobDto newjob = garageSer.addJobInGarage(garageId,problemId, job);
		if (newjob != null) {
			return new ResponseEntity<JobDto>(newjob, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to add job"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("findjob/{id}")
	public ResponseEntity<?> findJobById(@PathVariable long id) {
		JobDto job = jobSer.findJobById(id);
		if (job != null) {
			return new ResponseEntity<JobDto>(job, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get job"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/removejob/{garageId}/{vehicleId}/{jobId}")
	public ResponseEntity<?> cancelJob(@PathVariable long garageId,@PathVariable long vehicleId, @PathVariable long jobId) {
		String rem = garageSer.removeJobFromGarage(garageId,vehicleId, jobId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(rem), HttpStatus.OK);
	}

	@PostMapping("/findpart/{id}")
	public ResponseEntity<?> findPartById(@PathVariable long id) {
		PartDto part = partSer.findPartById(id);
		if (part != null) {
			return new ResponseEntity<PartDto>(part, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get Part"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/findservice/{id}")
	public ResponseEntity<?> findServicetById(@PathVariable long id) {
		ServiceDto service = serviceSer.findServiceById(id);
		if (service != null) {
			return new ResponseEntity<ServiceDto>(service, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get Service"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@RequestParam String email, @RequestParam String newPassword){
		String message= garageSer.forgotPassword(email, newPassword);
		return new ResponseEntity<ApiResponse>(new ApiResponse(message), HttpStatus.OK);
	}
	
	@GetMapping("/generatebill/{jobId}")
	public ResponseEntity<?> generateBill(@PathVariable long jobId){
		BillDto bill=jobSer.generateBill(jobId);
		if (bill != null) {
			return new ResponseEntity<BillDto>(bill, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get Bill"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getservicerequests")
	public ResponseEntity<?> getServiceRequests(){
		List<ProblemDto> problems=problemSer.findProblemsByStatus("Initiated");
		if (problems != null) {
			return new ResponseEntity<List<ProblemDto>>(problems, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get Problems"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findproblembyjob/{jobId}")
	public ResponseEntity<?> findProblemByJob(@PathVariable long jobId){
		ProblemDto problem=jobSer.findProblemByJob(jobId);
		if (problem != null) {
			return new ResponseEntity<ProblemDto>(problem, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get Problem"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findproblem/{id}")
	public ResponseEntity<?> findProblemById(@PathVariable long id){
		ProblemDto problem=problemSer.findProblemById(id);
		if (problem != null) {
			return new ResponseEntity<ProblemDto>(problem, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get Problem"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("findgaragebyproblem/{id}")
	public ResponseEntity<?> findGarageByProblem(@PathVariable long id) {
		GarageDto garage = jobSer.findGarageByProblem(id);
		if (garage != null) {
			return new ResponseEntity<GarageDto>(garage, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to get job"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
