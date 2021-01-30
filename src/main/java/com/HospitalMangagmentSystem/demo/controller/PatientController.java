package com.HospitalMangagmentSystem.demo.controller;


	import java.net.URI;
import java.sql.Date;
import java.util.List;

	import javax.transaction.Transactional;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.HospitalMangagmentSystem.demo.Dto.PatientDto;
import com.HospitalMangagmentSystem.demo.Service.PatientService;
import com.HospitalMangagmentSystem.demo.domain.Address;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.domain.Refdiseases;
import com.HospitalMangagmentSystem.demo.repository.AddressRepository;
import com.HospitalMangagmentSystem.demo.repository.PatientRepository;
import com.HospitalMangagmentSystem.demo.repository.PublicorprivateinsuranceRepository;
import com.HospitalMangagmentSystem.demo.repository.RefcalendarRepository;
import com.HospitalMangagmentSystem.demo.repository.Refdiseasesrepository;


	@RestController
	public class PatientController {

		@Autowired
		PatientService patiservice;
		
		@GetMapping("/Patient")
		public List<Patients> getPatient(){
		
			return this.patiservice.getallpatient();
		}
		
		@PostMapping("/Patient/")
		@Transactional
		public ResponseEntity<Object>  createpatient(@RequestBody PatientDto patidt) {
				Patients patsave =this.patiservice.createpatient(patidt);
				URI location = ServletUriComponentsBuilder
		                .fromCurrentRequest()
		                .path("/{id}")
		                .buildAndExpand(patsave.getPatient_ID()).toUri();
				return ResponseEntity.created(location).build();
			
			
		}
		
		@GetMapping("/Patient/{id}")
		@Transactional
		public Patients getonepatient( @PathVariable int id) {
			
			return this.patiservice.getonepatient(id);		
			
		}
		
		@DeleteMapping("/Patient/{id}")
		@Transactional
		public void deletepatient(@RequestBody PatientDto patientdto , @PathVariable int id) {
			this.patiservice.deletepatient(id);
			
			
		}
		
		/*@PutMapping("/Patient/{id}")
		@Transactional
		public Patients updatepatient(@RequestBody PatientDto pati , @PathVariable int id) {
			return this.patiservice.ubdatepatient(pati, id);
			
			
		}*/
		
		
		
		
	}


