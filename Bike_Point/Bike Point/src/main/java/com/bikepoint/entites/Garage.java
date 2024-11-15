package com.bikepoint.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "garages")
@Getter
@Setter
public class Garage extends User {
	@Column(length = 15)
	private String garageName;
	@Column(length = 150)
	private String address;
	private double longitude;
    private double latitude;
    @Column(length = 10)
	private String mobileNo;
	@OneToMany(mappedBy = "garage",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Job> jobs=new ArrayList<>();
	public Garage() {
		// TODO Auto-generated constructor stub
	}
	
	public void addJob(Job job) {
		jobs.add(job);
		job.setGarage(this);
	}
	
	public void removeJob(Job job) {
		jobs.remove(job);
		job.setGarage(null);
	}

	@Override
	public String toString() {
		return "Garage [address=" + address +  ", Id=" + getId()
				+ ", Email=" + getEmail() + ", Mobile No=" + mobileNo + "]";
	}
	
	
}
