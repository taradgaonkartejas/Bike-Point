package com.bikepoint;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	PasswordEncoder passwordEncoader;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
	.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoader.encode("abc@123"));
		
	}

	
}
