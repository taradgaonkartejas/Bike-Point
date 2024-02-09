package com.bikepoint.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "services")
public class Service extends BaseEntity {
	@Column(length = 20)
	private String serviceType;
	private double serviceCost;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id")
	private Job job;

	public Service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Service [serviceType=" + serviceType + ", serviceCost=" + serviceCost + ", job=" + job + ", Id="
				+ getId() + "]";
	}
	
	
	
}
