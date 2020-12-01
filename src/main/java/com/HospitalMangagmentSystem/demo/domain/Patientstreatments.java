package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the patients_treatments database table.
 * 
 */
@Entity
@Table(name="patients_treatments")
@NamedQuery(name="PatientsTreatment.findAll", query="SELECT p FROM Patientstreatments  p")
public class Patientstreatments extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int patients_Treatments_id;

	private String other_Details;

	//bi-directional many-to-one association to HelpScore
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="Help_Score")
	//@JsonIgnore
	//@JsonBackReference
	private Helpscore helpScore;

	//bi-directional many-to-one association to Patient
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="Patient_id")
	//@JsonIgnore
	//@JsonBackReference

	private Patients patient;

	//bi-directional many-to-one association to SideEffectScore
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="Side_Effect_Score")
	//@JsonBackReference
	//@JsonIgnore

	private Sideeffectscores sideEffectScore;

	//bi-directional many-to-one association to RefCalendar
	@ManyToOne( fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Treatment_Day_Date_Time")
	//@JsonIgnore
	//@JsonBackReference

	private Refcalendar refCalendar;

	//bi-directional many-to-one association to Treatment
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="Treatment_id")
	//@JsonIgnore
	//@JsonBackReference
	private Treatments treatment;

	public Patientstreatments() {
	}

	public int getPatients_Treatments_id() {
		return this.patients_Treatments_id;
	}

	public void setPatients_Treatments_id(int patients_Treatments_id) {
		this.patients_Treatments_id = patients_Treatments_id;
	}

	public String getOther_Details() {
		return this.other_Details;
	}

	public void setOther_Details(String other_Details) {
		this.other_Details = other_Details;
	}

	public Helpscore getHelpScore() {
		return this.helpScore;
	}

	public void setHelpScore(Helpscore helpScore) {
		this.helpScore = helpScore;
	}

	public Patients getPatient() {
		return this.patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public Sideeffectscores getSideEffectScore() {
		return this.sideEffectScore;
	}

	public void setSideEffectScore(Sideeffectscores sideEffectScore) {
		this.sideEffectScore = sideEffectScore;
	}

	public Refcalendar getRefCalendar() {
		return this.refCalendar;
	}

	public void setRefCalendar(Refcalendar refCalendar) {
		this.refCalendar = refCalendar;
	}

	public Treatments getTreatment() {
		return this.treatment;
	}

	public void setTreatment(Treatments treatment) {
		this.treatment = treatment;
	}

}