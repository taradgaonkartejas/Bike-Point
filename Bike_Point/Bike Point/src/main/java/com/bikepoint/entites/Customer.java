package com.bikepoint.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends User {
	
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 150)
	private String address;
	@Column(length = 10)
	private String mobileNo;
	private LocalDate dob;
	@OneToMany(mappedBy = "customer", orphanRemoval = true)
	private List<Problem> problems=new ArrayList<Problem>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

	public void addVehicle(Problem problem) {
		problems.add(problem);
		problem.setCustomer(this);
	}
	
	public void removeVehicle(Problem problem) {
		problems.remove(problem);
		problem.setCustomer(null);
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", dob=" + dob
				+ ", Id=" + getId() + ", Email=" + getEmail() + "]";
	}

	
	
}
