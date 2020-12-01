package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the `public_ or_ private_ insurance` database table.
 * 
 */
@Entity
@Table(name="`public_ or_ private_ insurance`")
@NamedQuery(name="Public_or_private_insurance.findAll", query="SELECT p FROM Publicorprivateinsurance p")
public class Publicorprivateinsurance extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="`public_ or_ private_ insurance _code`")
	private String public_or_private_insurance_Code;
	
    @OneToMany(mappedBy="Public_or_Private_Insurance_Code", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Patients> patients ;
	
    public Publicorprivateinsurance() {
	}

	public String getPublic_or_private_insurance_Code() {
		return this.public_or_private_insurance_Code;
	}

	public void setPublic_or_private_insurance_Code(String public_or_private_insurance_Code) {
		this.public_or_private_insurance_Code = public_or_private_insurance_Code;
	}

}