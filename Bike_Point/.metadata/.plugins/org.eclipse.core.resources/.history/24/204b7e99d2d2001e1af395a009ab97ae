package com.bikepoint.entites;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String password;
	public User() {
		// TODO Auto-generated constructor stub
	}
}
