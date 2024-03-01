package com.bikepoint.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "databese_parts")
@Getter
@Setter
public class PartDatabase extends BaseEntity {

	@Column(length = 20)
	private String partName;
	private double partCost;
	@Column(length = 20)
	private String companyName;

	public PartDatabase() {
		// TODO Auto-generated constructor stub
	}
}
