package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import java.sql.Date;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="patient")
@NamedQuery(name="Patients.findAll", query="SELECT a FROM Patients a")
public class Patients {
	@Id
	@GeneratedValue
	private int Patient_ID;
	private int Date_Of_Birth;
	private String Other_Details;
	
	public String getOther_Details() {
		return Other_Details;
	}

	public Address getAddress() {
		return address;
	}

	public Set<Patientstreatments> getPatienttreatment() {
		return patienttreatment;
	}

	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL)
	 private Set<DoctorsVisit> doctors_visits;
	
	
	@ManyToOne
	@JoinColumn(name="day_Date_Time")
	private Refcalendar Date_Acquired_Disease;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="diease_Code")
	
	private Refdiseases Disease_Code;
	
	@ManyToOne
	@JoinColumn(name="Public_or_Private_Insurance_Code")
	//@JsonManagedReference
	private Publicorprivateinsurance Public_or_Private_Insurance_Code;

	@ManyToOne
	@JoinColumn(name="addres_id")
	private Address address;
	
	@OneToMany(mappedBy="patient",  cascade = CascadeType.ALL)
	 @JsonIgnore
	private Set<Patientstreatments> patienttreatment;

	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}

	public int getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	
	public void setDate_Of_Birth(int date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
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

	public Refcalendar getDate_Acquired_Disease() {
		return Date_Acquired_Disease;
	}

	public void setDate_Acquired_Disease(Refcalendar date_Acquired_Disease) {
		Date_Acquired_Disease = date_Acquired_Disease;
	}

	public Refdiseases getDisease_Code() {
		return Disease_Code;
	}

	public void setDisease_Code(Refdiseases disease_Code) {
		Disease_Code = disease_Code;
	}

	public Publicorprivateinsurance getPublic_or_Private_Insurance_Code() {
		return Public_or_Private_Insurance_Code;
	}

	public void setPublic_or_Private_Insurance_Code(Publicorprivateinsurance public_or_Private_Insurance_Code) {
		Public_or_Private_Insurance_Code = public_or_Private_Insurance_Code;
	}

	public Address getHome_Address_ID() {
		return address;
	}

	public void setHome_Address_ID(Address home_Address_ID) {
		address = home_Address_ID;
	}
	
}