package com.bikepoint.dto;

import java.time.LocalDateTime;

public class ApiResponse {

	private LocalDateTime time;
	private String message;
	public ApiResponse(String message) {
		this.time=LocalDateTime.now();
		this.message = message;
	}
	@Override
	public String toString() {
		return "ApiResponce [time=" + time + ", message=" + message + "]";
	}
	
	
	
}
