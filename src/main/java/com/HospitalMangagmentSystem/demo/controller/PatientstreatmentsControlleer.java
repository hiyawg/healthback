package com.HospitalMangagmentSystem.demo.controller;

	import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.http.ResponseEntity;

import com.HospitalMangagmentSystem.demo.repository.HelpscoreRepository;
import com.HospitalMangagmentSystem.demo.repository.PatientRepository;
import com.HospitalMangagmentSystem.demo.repository.PatienttreatmentRepository;
import com.HospitalMangagmentSystem.demo.repository.RefcalendarRepository;
import com.HospitalMangagmentSystem.demo.repository.SideeffectRepository;
import com.HospitalMangagmentSystem.demo.repository.TreatmentsRepository;

import java.net.URI;
import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;

import com.HospitalMangagmentSystem.demo.Dto.patienttreatmentDto;
import com.HospitalMangagmentSystem.demo.Service.PatienttreatmentService;
import com.HospitalMangagmentSystem.demo.domain.Helpscore;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.domain.Sideeffectscores;
import com.HospitalMangagmentSystem.demo.domain.Treatments;

import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.PathVariable;



	@RestController
	public class PatientstreatmentsControlleer {
		 @Autowired
		  PatienttreatmentService pattreatservice;
		
		 
		 @GetMapping("/PatientsTreatments")

		    public List<Patientstreatments> getPatientsTreatment(){

		         return pattreatservice.getallpatienttreat();
	}

	     @PostMapping("/PatientsTreatments/")
	     @Transactional
	    public ResponseEntity<Object> savePatientsTreatment(@RequestBody patienttreatmentDto pt ){
	    	Patientstreatments ptreatsave=this.pattreatservice.createpatienttreat(pt);
	    	URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(ptreatsave.getPatients_Treatments_id()).toUri();
			return ResponseEntity.created(location).build();
		
	     }
	     @GetMapping("/PatientsTreatments/{id}")
	    public Patientstreatments getonePatientsTreatments(@PathVariable int id){
	         return this.getonePatientsTreatments(id);
	     }

	     @DeleteMapping("/PatientsTreatments/{id}")
	    public void delete(@PathVariable int id ){
	         this.pattreatservice.deletepatienttreat(id);
	     }

	     @PutMapping("/PatientsTreatments/{id}")
	     @Transactional
	         public Patientstreatments updatPatientsTreatments(@PathVariable int id ,
	        		 @RequestBody  patienttreatmentDto pt){
	    	
	     
	          return this.pattreatservice.ubdatepatienttreat(pt, id);
	     }
	
	}

