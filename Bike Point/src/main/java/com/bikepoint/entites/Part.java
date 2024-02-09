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
@Table(name = "parts")
@Getter
@Setter
public class Part extends BaseEntity {
	@Column(length = 20)
	private String partName;
	@Column(length = 20)
	private double partCost;
	@Column(length = 20)
	private String companyName;
	private long quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	private Job job;

	public Part() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Part [partName=" + partName + ", partCost=" + partCost + ", companyName=" + companyName + ", quantity="
				+ quantity + ", job=" + job + ", Id=" + getId() + "]";
	}
	
	
}
