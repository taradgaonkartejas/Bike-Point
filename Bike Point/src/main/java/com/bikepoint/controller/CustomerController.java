package com.bikepoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.bikepoint.dto.VehicleDto;
import com.bikepoint.service.CustomerService;
import com.bikepoint.service.GarageService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custSer;
	
	@Autowired
	private GarageService garageSer;

	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody @Valid CustomerDto customer) {
		CustomerDto cust = custSer.addCustomer(customer);
		if (cust != null) {
			return new ResponseEntity<CustomerDto>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Registration Failed"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/login")
	public ResponseEntity<?> authenticateCustomer(@RequestParam String email, @RequestParam String password) {
		CustomerDto cust = custSer.validateCustomer(email, password);
		if (cust != null) {
			return new ResponseEntity<CustomerDto>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid email or password"), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/addvehicle/{id}")
	public ResponseEntity<?> addVehicle(@PathVariable long id, @RequestBody @Valid VehicleDto vehicle){
		VehicleDto veh = custSer.addVehicle(id, vehicle);
		if (veh != null) {
			return new ResponseEntity<VehicleDto>(veh, HttpStatus.OK);
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
}
