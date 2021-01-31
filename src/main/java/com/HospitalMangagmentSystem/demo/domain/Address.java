package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends AuditModel{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	@GeneratedValue//(strategy=GenerationType.IDENTITY)
	private int address_id;

	
	private String address_detail;

	
	
	//bi-directional Many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name="country_Code" )

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	 //@JsonIgnore
	  private Countries countries;
	
	//bi-directional Many-to-one association to Country
		@ManyToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
		 @JoinColumn(name="City_Code")
		//@JsonBackReference
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
		//@JsonIgnore
		 private Cites city;
		
		@ManyToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
		 @JoinColumn(name="doctorid")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
		// @JsonBackReference
		//@JsonIgnore
		private Doctor doctor;

	   @ManyToOne
	   @JoinColumn(name="PATIENT_ID")
	   @JsonBackReference
		private Patients patient;
		
		
	public int getAddress_id() {
		return this.address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getAddress_detail() {
		return this.address_detail;
	}

	public Countries getCountries() {
		return countries;
	}

	public void setCountries(Countries countries) {
		this.countries = countries;
	}

	public Cites getCity() {
		return city;
	}

	public void setCity(Cites city) {
		this.city = city;
	}

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}
}












