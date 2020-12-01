package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.patienttreatmentDto;
import com.HospitalMangagmentSystem.demo.domain.Helpscore;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.domain.Sideeffectscores;
import com.HospitalMangagmentSystem.demo.domain.Treatments;
import com.HospitalMangagmentSystem.demo.repository.PatienttreatmentRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Component
@JsonDeserialize
public class PatienttreatmentserviceImplementation implements PatienttreatmentService{
    @Autowired
    PatienttreatmentRepository patreatrep;
	@Override
	public List<Patientstreatments> getallpatienttreat() {
		// TODO Auto-generated method stub
		return patreatrep.findAll();
	}

	@Override
	public Patientstreatments getonepatienttreat(int id) {
		// TODO Auto-generated method stub
		Patientstreatments pt=patreatrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patienttreatments with id " + id + " not found") );
		
		return pt;
	}

	@Override
	public Patientstreatments createpatienttreat(patienttreatmentDto ptd) {
		// TODO Auto-generated method stub
		Patientstreatments pt = new Patientstreatments();
		pt.setOther_Details(ptd.getOtherdetails());
		
		 
		Patients pp = new Patients();
				pp.setDateOfbirth(ptd.getDateOfbirth());
		   pt.setPatient(pp);
		   
		   Treatments treat = new Treatments();
		      treat.setTreatmentcost(ptd.getTreatmentcost());
		      treat.setMedicationorsugery(ptd.getMedicationorsugery());
		      treat.setOtherdetails(ptd.getOtherdetails());
		      pt.setTreatment(treat);
		      
		      Refcalendar cal = new Refcalendar();
		       cal.setDay_Date_Time(ptd.getDay_Date_Time());
		       cal.setDay_Number(ptd.getDay_Number());
		       pt.setRefCalendar(cal);
		       
		       Helpscore help = new Helpscore();
		         help.setHelp_Score(ptd.getHelp_Score());
		         pt.setHelpScore(help);
		         
		         Sideeffectscores side = new Sideeffectscores();
		           side.setSide_Effect_Score(ptd.getSide_Effect_Score());
		            pt.setSideEffectScore(side);
		        		 
		return patreatrep.save(pt);
	}

	@Override
	public void deletepatienttreat(int id) {
		// TODO Auto-generated method stub
		patreatrep.deleteById(id);
		
	}

	@Override
	public Patientstreatments ubdatepatienttreat(patienttreatmentDto ptd, int id) {
		// TODO Auto-generated method stub
		Patientstreatments pt=patreatrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patienttreatments with id " + id + " not found") );
		pt.setOther_Details(ptd.getOtherdetails());

		Patients pp = new Patients();
		pp.setDateOfbirth(ptd.getDateOfbirth());
		pt.setPatient(pp);

		Treatments treat = new Treatments();
		treat.setTreatmentcost(ptd.getTreatmentcost());
		treat.setMedicationorsugery(ptd.getMedicationorsugery());
		treat.setOtherdetails(ptd.getOtherdetails());
		pt.setTreatment(treat);

		Refcalendar cal = new Refcalendar();
		cal.setDay_Date_Time(ptd.getDay_Date_Time());
		cal.setDay_Number(ptd.getDay_Number());
		pt.setRefCalendar(cal);

		Helpscore help = new Helpscore();
		help.setHelp_Score(ptd.getHelp_Score());
		pt.setHelpScore(help);

		Sideeffectscores side = new Sideeffectscores();
		side.setSide_Effect_Score(ptd.getSide_Effect_Score());
		pt.setSideEffectScore(side);

		return patreatrep.save(pt);
	}

}
