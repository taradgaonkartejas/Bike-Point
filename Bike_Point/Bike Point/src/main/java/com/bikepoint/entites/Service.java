package com.bikepoint.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "services")
public class Service extends BaseEntity {
	@Column(length = 20)
	private String serviceName;
	private double serviceCost;

	public Service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Service [serviceType=" + serviceName + ", serviceCost=" + serviceCost + ", Id="
				+ getId() + "]";
	}
	
	
	
}
