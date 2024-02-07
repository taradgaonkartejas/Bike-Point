package com.bikepoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikepoint.dto.CustomerDto;
import com.bikepoint.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService custSer;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody @Valid CustomerDto customer){
		
		return new ResponseEntity<CustomerDto>(custSer.addCustomer(customer),HttpStatus.OK);
	}

}
