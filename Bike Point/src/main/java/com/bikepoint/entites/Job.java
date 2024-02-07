package com.bikepoint.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job extends BaseEntity {
	@ManyToOne()
	@JoinColumn(name = "garage_id", nullable = false)
	private Garage garage;
	@ManyToOne()
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	@OneToMany(mappedBy = "job",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Service> services= new ArrayList<Service>();
	@OneToMany(mappedBy = "job",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Part> parts = new ArrayList<>();
	
	public Job() {
		// TODO Auto-generated constructor stub
	}
	
	public void addService(Service service) {
		services.add(service);
		service.setJob(this);
	}

	public void removeService(Service service) {
		services.remove(service);
		service.setJob(null);
	}
	
	public void addPart(Part part) {
		parts.add(part);
		part.setJob(this);
	}

	public void removePart(Part part) {
		parts.remove(part);
		part.setJob(null);
	}

	@Override
	public String toString() {
		return "Job [garage=" + garage + ", Id=" + getId() + "]";
	}
	
	
}
