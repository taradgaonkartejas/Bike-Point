package com.bikepoint.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "problems")
public class Problem extends BaseEntity {
	@Column(length = 20)
	private String vehicleCompany;
	@Column(length = 20)
	private String vehicleModel;
	@Enumerated(EnumType.STRING)
	private ProblemType problemType;
	@Column(length = 100)
	private String problemDescription;
	@Column(length = 100)
	private String address;
	private double longitude;
    private double latitude;
	@Column(length = 20)
	String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToMany(mappedBy = "problem", orphanRemoval = true)
	private List<Job> jobs= new ArrayList<>();
	
	public Problem() {
		// TODO Auto-generated constructor stub
	}
	
	public void addJob(Job job) {
		jobs.add(job);
		job.setProblem(this);
	}
	
	public void removeJob(Job job) {
		jobs.remove(job);
		job.setProblem(null);
	}

	@Override
	public String toString() {
		return "Vehicle [vehileModel"+getId()+"  vehicleCompany=" + vehicleCompany + ", vehicleModel=" + vehicleModel + ", problemType="
				+ problemType + ", problemDescription=" + problemDescription + "]";
	}
	
	
	
}
