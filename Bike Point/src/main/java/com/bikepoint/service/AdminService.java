package com.bikepoint.service;

import com.bikepoint.dto.AdminDto;

public interface AdminService {

	public AdminDto validateAdmin(String email, String password);
}
