package com.HospitalMangagmentSystem.demo.Dto;

public class Treatmentdto {
	private int treatmentid;

    private char medicationorsugery;

    private Double treatmentcost;

    private String otherdetails;

	public int getTreatmentid() {
		return treatmentid;
	}

	

	public char getMedicationorsugery() {
		return medicationorsugery;
	}

	
	public Double getTreatmentcost() {
		return treatmentcost;
	}

	public void setTreatmentcost(Double treatmentcost) {
		this.treatmentcost = treatmentcost;
	}

	public String getOtherdetails() {
		return otherdetails;
	}

    

}
