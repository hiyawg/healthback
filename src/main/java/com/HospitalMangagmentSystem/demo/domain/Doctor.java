package com.HospitalMangagmentSystem.demo.domain;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the doctors database table.
 * 
 */
@Entity
@Table(name="doctors")
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int doctor_ID;

	private String doctor_Details;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Work_Address_ID")
	private Address address;

	//bi-directional many-to-one association to DoctorsVisit
	@OneToMany(mappedBy="doctor",  cascade = CascadeType.ALL)
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

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
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