package com.HospitalMangagmentSystem.demo.domain;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the side_effect_scores database table.
 * 
 */
@Entity
@Table(name="side_effect_scores")
@NamedQuery(name="SideEffectScore.findAll", query="SELECT s FROM Sideeffectscores s")
public class Sideeffectscores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int Side_Effect_Score;
	@OneToMany(mappedBy="sideEffectScore",  cascade = CascadeType.ALL)
	 @JsonIgnore
	private Set<Patientstreatments> Patients_Treatments;

	

	public Sideeffectscores() {
	}

	public int getSide_Effect_Score() {
		return this.Side_Effect_Score;
	}

	public void setSide_Effect_Score(int idSide_Effect_Score) {
		this.Side_Effect_Score = idSide_Effect_Score;
	}

	public Set<Patientstreatments> getPatients_Treatments() {
		return Patients_Treatments;
	}

	public void setPatients_Treatments(Set<Patientstreatments> patients_Treatments) {
		Patients_Treatments = patients_Treatments;
	}
	
}