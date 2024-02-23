package com.bikepoint.controller;


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

import com.bikepoint.dto.AdminDto;
import com.bikepoint.dto.ApiResponse;
import com.bikepoint.dto.GarageDto;
import com.bikepoint.dto.PartDto;
import com.bikepoint.service.AdminService;
import com.bikepoint.service.GarageService;
import com.bikepoint.service.PartService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminSer;

	@Autowired
	private GarageService garageSer;

	@Autowired
	private PartService partSer;

	@GetMapping("/login")
	public ResponseEntity<?> authenticateCustomer(@RequestParam String email, @RequestParam String password) {
		AdminDto cust = adminSer.validateAdmin(email, password);
		if (cust != null) {
			return new ResponseEntity<AdminDto>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid email or password"), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/addgarage")
	public ResponseEntity<?> addGarage(@RequestBody @Valid GarageDto garage) {
		GarageDto gar = garageSer.addGarage(garage);
		if (gar != null) {
			return new ResponseEntity<GarageDto>(gar, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Problem occurred"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/removegarage/{id}")
	public ResponseEntity<?> removeGarage(@PathVariable Long id) {
		String rem = garageSer.removeGarage(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(rem), HttpStatus.OK);
	}

	@PostMapping("/addpart")
	public ResponseEntity<?> addPart(@RequestBody @Valid PartDto part) {
		PartDto par = partSer.addPart(part);
		if (par != null) {
			return new ResponseEntity<PartDto>(par, HttpStatus.OK);
		} else {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Problem occurred"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
