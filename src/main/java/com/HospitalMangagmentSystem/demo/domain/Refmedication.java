package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Ref_Medication database table.
 * 
 */
@Entity
@Table(name="RefMedication")
@NamedQuery(name="RefMedication.findAll", query="SELECT r FROM Refmedication r")
public class Refmedication extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int medicationcode;

	private String medicationname;

	private String medicatiodescription;
	
	//bi-directional many-to-one association to Treatments 
	 @OneToMany(mappedBy="medication", cascade = CascadeType.ALL)
	 @JsonIgnore
	// @JsonBackReference
	private Set<Treatments> Treatments;


	public Refmedication() {
	}


	public int getMedicationcode() {
		return medicationcode;
	}


	public void setMedicationcode(int medicationcode) {
		this.medicationcode = medicationcode;
	}


	public String getMedicationname() {
		return medicationname;
	}


	public void setMedicationname(String medicationname) {
		this.medicationname = medicationname;
	}


	public String getMedicatiodescription() {
		return medicatiodescription;
	}


	public void setMedicatiodescription(String medicatiodescription) {
		this.medicatiodescription = medicatiodescription;
	}


	public Set<Treatments> getTreatments() {
		return Treatments;
	}


	public void setTreatments(Set<Treatments> treatments) {
		Treatments = treatments;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
