package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Ref_Surgery database table.
 * 
 */
@Entity
@Table(name="RefSurgery")
@NamedQuery(name="RefSurgery.findAll", query="SELECT r FROM Refsurgery r")
public class Refsurgery extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
   //@JsonIgnore
   @GeneratedValue
	private int Surgery_Code;

	private String Surgery_Name;

	private String Surgery_Description;
	
	
    //bi-directional many-to-one association to Treatments 
	@OneToMany(mappedBy="surgery", cascade = CascadeType.ALL)
	private Set<Treatments> Treatments;


	public Refsurgery() {
	}

	public int getSurgery_Code() {
		return this.Surgery_Code;
	}

	public void setSurgery_Code(int Surgery_Code) {
		this.Surgery_Code = Surgery_Code;
	}

	public String getSurgery_Name() {
		return this.Surgery_Name;
	}

	public void setSurgery_Name(String Surgery_Name) {
		this.Surgery_Name = Surgery_Name;
	}

        public String getSurgery_Description() {
		return this.Surgery_Description;
	}

	public void setSurgery_Description(String Surgery_Description) {
		this.Surgery_Description = Surgery_Description;
	}

}

