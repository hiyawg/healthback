package com.HospitalMangagmentSystem.demo.Dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientDto {
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date dateofbirth;
	private String patientname;

	private String otherdetails;
	
	private String addressdetail;
	
	private String publicorprivateinsurancecode;
	
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date daydatetime;

	private int daynumber;
	
	private String dieasecode;

	private String diseasedescription;

	private String diseasename;


	public String getAddressdetail() {
		return addressdetail;
	}

	public String getPatientname() {
		return patientname;
	}

	public String getPublicorprivateinsurancecode() {
		return publicorprivateinsurancecode;
	}


	public Date getDaydatetime() {
		return daydatetime;
	}


	public int getDaynumber() {
		return daynumber;
	}


	public String getDieasecode() {
		return dieasecode;
	}


	public String getDiseasedescription() {
		return diseasedescription;
	}


	public String getDiseasename() {
		return diseasename;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}
	public String getOtherdetails() {
		return otherdetails;
	}
	
	
	
}
