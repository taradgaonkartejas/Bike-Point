package com.bikepoint.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.bikepoint.entites.ProblemType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JobDto {
	@ReadOnlyProperty
	private int id;

}
