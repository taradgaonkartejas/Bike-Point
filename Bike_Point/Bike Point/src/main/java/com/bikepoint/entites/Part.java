package com.bikepoint.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parts")
@Getter
@Setter
public class Part extends BaseEntity {
	@Column(length = 20)
	private String partName;
	private double partCost;
	@Column(length = 20)
	private String companyName;
	private long quantity;
	
	public Part() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Part [partName=" + partName + ", partCost=" + partCost + ", companyName=" + companyName + ", Id=" + getId() + "]";
	}
	
	
}
