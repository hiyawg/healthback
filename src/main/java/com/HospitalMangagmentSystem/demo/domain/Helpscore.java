package com.HospitalMangagmentSystem.demo.domain;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the help_scores database table.
 * 
 */
@Entity
@Table(name="help_scores")
@NamedQuery(name ="HelpScore.findAll", query="SELECT h FROM Helpscore h")
public class Helpscore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int help_Score;
	
	@OneToMany(mappedBy="helpScore",  cascade = CascadeType.ALL)
	 @JsonIgnore
	private Set<Patientstreatments> Patients_Treatments;

	

	public Helpscore() {
	}

	public int getHelp_Score() {
		return this.help_Score;
	}

	public void setHelp_Score(int help_Score) {
		this.help_Score = help_Score;
	}
	
	public Set<Patientstreatments> getPatients_Treatments() {
		return Patients_Treatments;
	}

}
