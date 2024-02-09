package com.bikepoint.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {
	@Column(length = 20)
	private String vehicleCompany;
	@Column(length = 20)
	private String vehicleModel;
	@Enumerated(EnumType.STRING)
	private ProblemType problemType;
	@Column(length = 100)
	private String problemDescription;
	@ManyToOne()
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	@OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Job> jobs= new ArrayList<>();
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public void addJob(Job job) {
		jobs.add(job);
		job.setVehicle(this);
	}
	
	public void removeJob(Job job) {
		jobs.remove(job);
		job.setVehicle(null);
	}

	@Override
	public String toString() {
		return "Vehicle [vehileModel"+getId()+"  vehicleCompany=" + vehicleCompany + ", vehicleModel=" + vehicleModel + ", problemType="
				+ problemType + ", problemDescription=" + problemDescription + "]";
	}
	
	
	
}
