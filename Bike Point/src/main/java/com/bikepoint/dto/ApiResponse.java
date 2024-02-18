package com.bikepoint.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
