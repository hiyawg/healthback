package com.HospitalMangagmentSystem.demo.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DoctorvisitDto {

	private String visitdetails;

	private String doctordetails;
	private String name ;

	private String department;


	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	 private Date dateofbirth;

	private String patientname;

		private String otherdetails;
		@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
		private Date daydatetime;

		private int daynumber;

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getPatientname() {
		return patientname;
	}

	public String getVisitdetails() {
		return visitdetails;
	}


	public String getDoctordetails() {
		return doctordetails;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public String getOtherdetails() {
		return otherdetails;
	}


	public Date getDaydatetime() {
		return daydatetime;
	}


	public int getDaynumber() {
		return daynumber;
	}
	

	

}
