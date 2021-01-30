package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the ref_calander database table.
 * 
 */
@Entity
@Table(name="ref_calander")
@NamedQuery(name="Ref_Calander.findAll", query="SELECT r FROM Refcalendar r")
public class Refcalendar extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")

	private Date day_Date_Time;

	private int day_Number;

	//bi-directional many-to-one association to DoctorsVisit
	@OneToMany(mappedBy="refCalender", cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonBackReference
	
	private Set<DoctorsVisit> doctorsVisits;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="day_Date_Time",  cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Patients> patients;

	//bi-directional many-to-one association to PatientsTreatment
	@OneToMany(mappedBy="refCalendar",  cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private Set<Patientstreatments> patientsTreatments;

	public Refcalendar() {
	}

	public Date getDay_Date_Time() {
		return this.day_Date_Time;
	}

	public void setDay_Date_Time(Date day_Date_Time) {
		this.day_Date_Time = day_Date_Time;
	}

	public int getDay_Number() {
		return this.day_Number;
	}

	public void setDay_Number(int day_Number) {
		this.day_Number = day_Number;
	}

	public Set<DoctorsVisit> getDoctorsVisits() {
		return this.doctorsVisits;
	}

	public void setDoctorsVisits(Set<DoctorsVisit> doctorsVisits) {
		this.doctorsVisits = doctorsVisits;
	}



	public Set<Patients> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patients> patients) {
		this.patients = patients;
	}

	public Set<Patientstreatments> getPatientsTreatments() {
		return this.patientsTreatments;
	}

	public void setPatientsTreatments(Set<Patientstreatments> patientsTreatments) {
		this.patientsTreatments = patientsTreatments;
	}

	

}
