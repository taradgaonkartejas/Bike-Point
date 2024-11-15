package com.bikepoint.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "jobs")
public class Job extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "garage_id")
	private Garage garage;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private Problem problem;
	@Column(length = 20)
	String status;
	@OneToMany
	private List<Service> services= new ArrayList<>();
	@OneToMany
	private List<Part> parts = new ArrayList<>();
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public void addPart(Part part) {
		parts.add(part);
	}
	
	public void removePart(Part part) {
		parts.remove(part);
	}

	public void addService(Service service) {
		services.add(service);
	}
	
	public void removeService(Service service) {
		services.remove(service);
	}
	
	@Override
	public String toString() {
		return "Job [garage=" + garage + ", Id=" + getId() + "]";
	}
	
	
}
