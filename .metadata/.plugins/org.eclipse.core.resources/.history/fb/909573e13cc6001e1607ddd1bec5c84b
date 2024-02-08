package com.bikepoint.entites;

import java.time.LocalDate;
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
@Table(name = "customers")
public class Customer extends User {
	
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 60)
	private String address;
	@Column(length = 10)
	private String mobileNo;
	private LocalDate dob;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles=new ArrayList<Vehicle>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public List<Vehicle> getVehicles() {
		return vehicles;
	}



	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}



	private void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		vehicle.setCustomer(this);
	}
	
	private void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
		vehicle.setCustomer(null);
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", dob=" + dob
				+ ", Id=" + getId() + ", Email=" + getEmail() + "]";
	}

	
	
}
