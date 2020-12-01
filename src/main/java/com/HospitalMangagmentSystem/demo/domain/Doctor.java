package com.HospitalMangagmentSystem.demo.domain;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the doctors database table.
 * 
 */
@Entity
@Table(name="doctors")
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int doctor_ID;
     
	
	private String doctor_Details;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="doctor",  cascade = CascadeType.ALL)
   // @JsonManagedReference 
	@JsonIgnore
	private Set<Address> address;

	//bi-directional many-to-one association to DoctorsVisit
	@OneToMany(mappedBy="doctor",  cascade = CascadeType.ALL)
	//@JsonManagedReference
	@JsonIgnore
	private Set<DoctorsVisit> doctorsVisits;

	public Doctor() {
	}

	public int getDoctor_ID() {
		return this.doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		this.doctor_ID = doctor_ID;
	}

	public String getDoctor_Details() {
		return this.doctor_Details;
	}

	public void setDoctor_Details(String doctor_Details) {
		this.doctor_Details = doctor_Details;
	}

	
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Address addAdreess(Address addres) {
		if(addres == null) {
			address = new HashSet<Address>();
		}
		getAddress().add(addres);
		addres.setDoctor(this);
		
		return addres;
	}

	public Set<DoctorsVisit> getDoctorsVisits() {
		return this.doctorsVisits;
	}

	public void setDoctorsVisits(Set<DoctorsVisit> doctorsVisits) {
		this.doctorsVisits = doctorsVisits;
	}

	public DoctorsVisit addDoctorsVisit(DoctorsVisit doctorsVisit) {
		getDoctorsVisits().add(doctorsVisit);
		doctorsVisit.setDoctor(this);

		return doctorsVisit;
	}

	public DoctorsVisit removeDoctorsVisit(DoctorsVisit doctorsVisit) {
		getDoctorsVisits().remove(doctorsVisit);
		doctorsVisit.setDoctor(null);

		return doctorsVisit;
	}

}