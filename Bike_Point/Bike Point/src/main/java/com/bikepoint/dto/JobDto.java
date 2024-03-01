package com.bikepoint.dto;


import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JobDto {
	@ReadOnlyProperty
	private int id;
	@ReadOnlyProperty
	String status;

}
