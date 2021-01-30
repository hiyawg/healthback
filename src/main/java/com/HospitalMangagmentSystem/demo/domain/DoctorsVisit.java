package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the doctors_visits database table.
 * 
 */
@Entity
@Table(name="doctors_visits")
@NamedQuery(name="DoctorsVisit.findAll", query="SELECT d FROM DoctorsVisit d")
public class DoctorsVisit extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	
	private int doctor_Visits_ID;

	private String visit_Details;

	//bi-directional many-to-one association to RefCalender
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Day_Date_Time")
	@JsonIgnoreProperties({"hiber nateLazyInitializer", "handler"})
	//@JsonManagedReference
	private Refcalendar refCalender;

	//bi-directional many-to-one association to Doctor
	@ManyToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
	@JoinColumn(name="Doctor_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	//@JsonIgnore
	private Doctor doctor;

	//bi-directional many-to-one association to Patient
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Patient_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Patients patient;

    @OneToMany(mappedBy="doctors_visits", cascade = CascadeType.ALL)
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<Payment> payments;


	public DoctorsVisit() {
	}

	public int getDoctor_Visits_ID() {
		return this.doctor_Visits_ID;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public void setDoctor_Visits_ID(int doctor_Visits_ID) {
		this.doctor_Visits_ID = doctor_Visits_ID;
	}

	public String getVisit_Details() {
		return this.visit_Details;
	}

	public void setVisit_Details(String visit_Details) {
		this.visit_Details = visit_Details;
	}

	public Refcalendar getRefCalender() {
		return this.refCalender;
	}

	public void setRefCalender(Refcalendar refCalender) {
		this.refCalender = refCalender;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patients getPatient() {
		return this.patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	

}