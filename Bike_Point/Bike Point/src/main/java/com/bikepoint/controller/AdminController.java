package com.bikepoint.controller;


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
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.PartDatabaseDto;
import com.bikepoint.dto.ServiceDto;
import com.bikepoint.service.AdminService;
import com.bikepoint.service.GarageService;
import com.bikepoint.service.PartDatabaseService;
import com.bikepoint.service.ServiceService;

@RestController
@RequestMapping("/admin")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private AdminService adminSer;

	@Autowired
	private GarageService garageSer;
	
	@Autowired
	private PartDatabaseService partDatabaseSer;
	
	@Autowired
	private ServiceService serviceSer;


	@PostMapping("/addgarage")
	public ResponseEntity<?> addGarage(@RequestBody @Valid GarageDto garage) {
		GarageDto gar = garageSer.addGarage(garage);
		if (gar != null) {
			return new ResponseEntity<GarageDto>(gar, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Problem occurred"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/removegarage/{id}")
	public ResponseEntity<?> removeGarage(@PathVariable Long id) {
		String rem = garageSer.removeGarage(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(rem), HttpStatus.OK);
	}

	@PostMapping("/addpart")
	public ResponseEntity<?> addPart(@RequestBody @Valid PartDatabaseDto part) {
		PartDatabaseDto par = partDatabaseSer.addPart(part);
		if (par != null) {
			return new ResponseEntity<PartDatabaseDto>(par, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Problem occurred"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addservice")
	public ResponseEntity<?> addPart(@RequestBody @Valid ServiceDto service) {
		ServiceDto ser = serviceSer.addService(service);
		if (ser != null) {
			return new ResponseEntity<ServiceDto>(ser, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Problem occurred"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@RequestParam String email, @RequestParam String newPassword){
		String message= adminSer.forgotPassword(email, newPassword);
		return new ResponseEntity<ApiResponse>(new ApiResponse(message), HttpStatus.OK);
	}
}
