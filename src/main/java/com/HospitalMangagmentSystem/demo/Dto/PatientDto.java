package com.HospitalMangagmentSystem.demo.Dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientDto {

	private String first;
	private String last;
	private String gender;
	private String mobile;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date dob;
	private int age;
	private String email;
	private String addresses;

	private String address_detail;
	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getGender() {
		return gender;
	}

	public String getMobile() {
		return mobile;
	}

	public Date getDob() {
		return dob;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getAddresses() {
		return addresses;
	}

	public String getAddress_detail() {
		return address_detail;
	}
}
