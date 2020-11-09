package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@Table(name="countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Countries c")
public class Countries implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="`Country-Code`")
	@GeneratedValue
	private int country_Code;

	@Column(name="`Country-Name`")
	private String country_Name;

	//bi-directional one-to-many association to Address
	@OneToMany(mappedBy="countries", cascade = CascadeType.ALL)
	//@JsonBackReference
	private Set<Address> addresses;

	public Countries() {
	
	}
	public int getCountry_Code() {
		return this.country_Code;
		}
	public String getCountry_Name() {
		return country_Name;
	}
	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public void setCountry_Code(int country_Code) {
		this.country_Code = country_Code;
	
}}