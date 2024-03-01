package com.bikepoint.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDto {
	private Long custId;
	private String custName;
	private Long jobId;
	private Long garageId;
	private List<PriceDto> workList= new ArrayList<>();
	private Double totalPrice;
	
	
	public BillDto(Long custId, String custName, Long jobId, Long garageId, List<PriceDto> workList) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.jobId = jobId;
		this.garageId = garageId;
		this.workList = workList;
	}


	@Override
	public String toString() {
		return "BillDto [custId=" + custId + ", custName=" + custName + ", jobId=" + jobId + ", garageId=" + garageId
				+ ", workList=" + workList + ", totalPrice=" + totalPrice + "]";
	}
	
}
