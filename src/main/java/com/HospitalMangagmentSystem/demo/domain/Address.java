package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int address_id;

	
	private String address_detail;

	
	
	//bi-directional Many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="country_Code")
//	@JsonIgnore

	  private Countries countries;
	
	//bi-directional Many-to-one association to Country
		@ManyToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
		 @JoinColumn(name="City_Code")
	//@JsonIgnore
		 private Cites city;
		
		@ManyToOne
		 @JoinColumn(name="doctorid")
		@JsonBackReference
		private Doctor doctor;
		
		@OneToMany(mappedBy="address", cascade = CascadeType.ALL)
		private Set<Patients> patient;
		
		
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


	

	public Set<Patients> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patients> patient) {
		this.patient = patient;
	}
	
}












