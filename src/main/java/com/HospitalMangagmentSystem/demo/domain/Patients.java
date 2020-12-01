package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="patient")
@NamedQuery(name="Patients.findAll", query="SELECT a FROM Patients a")
public class Patients extends AuditModel {
	@Id
	@GeneratedValue
	private int Patient_ID;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date DateOfbirth;
	
	private String Other_Details;
	
	public String getOther_Details() {
		return Other_Details;
	}

	public Address getAddress() {
		return address;
	}
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<Patientstreatments> getPatienttreatment() {
		return patienttreatment;
	}

	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL)
//	@JsonBackReference 
//	@JsonIgnore
	 private Set<DoctorsVisit> doctors_visits;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="day_Date_Time")
	@JsonIgnore
	private Refcalendar day_Date_Time;
	
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="diease_Code")
	//@JsonManagedReference
	@JsonIgnore
	private Refdiseases Disease;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Public_or_Private_Insurance_Code")
	//@JsonManagedReference
	@JsonIgnore
	private Publicorprivateinsurance Public_or_Private_Insurance_Code;

	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="addres_id")
	@JsonIgnore
	//@JsonBackReference
	private Address address;
	
	@OneToMany(mappedBy="patient",  cascade = CascadeType.ALL)
	@JsonIgnore
	 //@JsonManagedReference
	private Set<Patientstreatments> patienttreatment;

	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}

	

	
	public Date getDateOfbirth() {
		return DateOfbirth;
	}

	public void setDateOfbirth(Date dateOfbirth) {
		DateOfbirth = dateOfbirth;
	}

	public Refdiseases getDisease() {
		return Disease;
	}

	public void setDisease(Refdiseases disease) {
		Disease = disease;
	}

	

	public void setOther_Details(String other_Details) {
		Other_Details = other_Details;
	}

	public void setPatienttreatment(Set<Patientstreatments> patienttreatment) {
		this.patienttreatment = patienttreatment;
	}

	public Set<DoctorsVisit> getDoctors_visits() {
		return doctors_visits;
	}

	public void setDoctors_visits(Set<DoctorsVisit> doctors_visits) {
		this.doctors_visits = doctors_visits;
	}

	

	public Refcalendar getDay_Date_Time() {
		return day_Date_Time;
	}

	public void setDay_Date_Time(Refcalendar day_Date_Time) {
		this.day_Date_Time = day_Date_Time;
	}

	

	public Publicorprivateinsurance getPublic_or_Private_Insurance_Code() {
		return Public_or_Private_Insurance_Code;
	}

	public void setPublic_or_Private_Insurance_Code(Publicorprivateinsurance public_or_Private_Insurance_Code) {
		Public_or_Private_Insurance_Code = public_or_Private_Insurance_Code;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}