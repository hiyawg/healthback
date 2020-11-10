package com.HospitalMangagmentSystem.demo.domain;


	import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Set;
@Entity
	public class Treatments implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue

	    private int treatmentid;

	    private char medicationorsugery;

	    private Double treatmentcost;

	    private String otherdetails;

	    //bi-directional many-to-one association to Ref_Medications
	    @ManyToOne( cascade = CascadeType.ALL)
	     @JoinColumn(name="medicationcode",referencedColumnName="medicationcode")
	 //  @JsonManagedReference
	    private Refmedication medication;

	    //bi-directional many-to-one association to Ref_Surgery
	    @ManyToOne( cascade = CascadeType.ALL)
	    @JoinColumn(name="Surgery_Code")
	    private Refsurgery surgery;
        
	    @OneToMany(mappedBy="treatment",  cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Set<Patientstreatments> pp;

	    public Treatments() {

	    }



	    public int getTreatmentid() {
	        return treatmentid;
	    }


	    public void setTreatmentid(int treatmentid) {
	        this.treatmentid = treatmentid;
	    }


	    public char getMedicationorsugery() {
	        return medicationorsugery;
	    }


	    public void setMedicationorsugery(char medicationorsugery) {
	        this.medicationorsugery = medicationorsugery;
	    }


	    public Double getTreatmentcost() {
	        return treatmentcost;
	    }


	    public void setTreatmentcost(Double treatmentcost) {
	        this.treatmentcost = treatmentcost;
	    }


	    public String getOtherdetails() {
	        return otherdetails;
	    }


	    public void setOtherdetails(String otherdetails) {
	        this.otherdetails = otherdetails;
	    }


	    public Refmedication getMedication() {
	        return medication;
	    }


	    public void setMedication(Refmedication medication) {
	        this.medication = medication;
	    }


	    public Refsurgery getSurgery() {
	        return surgery;
	    }


	    public void setSurgery(Refsurgery surgery) {
	        this.surgery = surgery;
	    }

	}



