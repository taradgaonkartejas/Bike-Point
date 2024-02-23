package com.bikepoint.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bikepoint.dto.LoginResponse;
import com.bikepoint.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserService userSer;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginResponse user= userSer.getUserByEmail(username);
		
		return user;
	}

}
