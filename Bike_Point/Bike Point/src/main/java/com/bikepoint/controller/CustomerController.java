package com.bikepoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikepoint.dto.ApiResponse;
import com.bikepoint.dto.CustomerDto;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.ProblemDto;
import com.bikepoint.entites.Problem;
import com.bikepoint.service.CustomerService;
import com.bikepoint.service.GarageService;
import com.bikepoint.service.ProblemService;


@RestController
@Validated
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custSer;
	
	@Autowired
	private GarageService garageSer;
	
	@Autowired
	private ProblemService problemSer;

	@PostMapping("/signup")
	public ResponseEntity<?> registerCustomer(@RequestBody @Valid CustomerDto customer) {
		System.out.println(customer);
		CustomerDto cust = custSer.addCustomer(customer);
		if (cust != null) {
			return new ResponseEntity<CustomerDto>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Registration Failed"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping("/getcustomer/{id}")
	public ResponseEntity<?> findCustomerById(@PathVariable long id){
		CustomerDto cust=custSer.findCustomer(id);
		if (cust != null) {
			return new ResponseEntity<CustomerDto>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Customer not exsistes!"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/addproblem/{id}")
	public ResponseEntity<?> addProblem(@PathVariable long id, @RequestBody @Valid ProblemDto vehicle){
		ProblemDto veh = custSer.addProblem(id, vehicle);
		if (veh != null) {
			return new ResponseEntity<ProblemDto>(veh, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to add vehicle"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/findgarages")
	public ResponseEntity<?> findAllGarages(){
		List<GarageDto> garages=garageSer.findAllGarages();
		if (garages != null) {
			return new ResponseEntity<List<GarageDto>>(garages, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to find garages"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@RequestParam String email, @RequestParam String newPassword){
		String message= custSer.forgotPassword(email, newPassword);
		return new ResponseEntity<ApiResponse>(new ApiResponse(message), HttpStatus.OK);
	}

	
	@GetMapping("/getallproblems/{id}")
	public ResponseEntity<?> getAllProblemsById(@PathVariable long id){
		List<ProblemDto> problems=custSer.findAllProblems(id);
		if (problems != null) {
			return new ResponseEntity<List<ProblemDto>>(problems, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Failed to find problems"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
