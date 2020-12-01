package com.HospitalMangagmentSystem.demo.Dto;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class patienttreatmentDto {
	private String otherdetails;
     
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date DateOfbirth;
	
	 private char medicationorsugery;

	    private Double treatmentcost;

	    private String treatmentdetails;
	    
             
	    @Temporal(TemporalType.TIMESTAMP)
		@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")

		private Date day_Date_Time;

		private int day_Number;
		
	
		private int help_Score;
		
		private int Side_Effect_Score;
	public Date getDateOfbirth() {
			return DateOfbirth;
		}
		public char getMedicationorsugery() {
			return medicationorsugery;
		}
		public Double getTreatmentcost() {
			return treatmentcost;
		}
		public String getTreatmentdetails() {
			return treatmentdetails;
		}
		public Date getDay_Date_Time() {
			return day_Date_Time;
		}
		public int getDay_Number() {
			return day_Number;
		}
		public int getHelp_Score() {
			return help_Score;
		}
		public int getSide_Effect_Score() {
			return Side_Effect_Score;
		}
	public String getOtherdetails() {
		return otherdetails;
	}

	
	
	
}
