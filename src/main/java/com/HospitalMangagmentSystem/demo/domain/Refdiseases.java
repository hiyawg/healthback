package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the ref_diseases database table.
 * 
 */
@Entity
@Table(name="ref_diseases")
@NamedQuery(name="RefDiseas.findAll", query="SELECT r FROM Refdiseases r")
public class Refdiseases extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	private String diease_Code;

	private String disease_Description;

	private String disease_Name;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="Disease", cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonBackReference 
	private Set<Patients> patients;

	public Refdiseases() {
	}

	public String getDiease_Code() {
		return this.diease_Code;
	}

	public void setDiease_Code(String diease_Code) {
		this.diease_Code = diease_Code;
	}

	public String getDisease_Description() {
		return this.disease_Description;
	}

	public void setDisease_Description(String disease_Description) {
		this.disease_Description = disease_Description;
	}

	public String getDisease_Name() {
		return this.disease_Name;
	}

	public void setDisease_Name(String disease_Name) {
		this.disease_Name = disease_Name;
	}

	public Set<Patients> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patients> patients) {
		this.patients = patients;
	}

	

}
