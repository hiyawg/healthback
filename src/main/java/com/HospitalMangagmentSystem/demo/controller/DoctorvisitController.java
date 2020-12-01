package com.HospitalMangagmentSystem.demo.controller;


	import java.net.URI;
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

import com.HospitalMangagmentSystem.demo.Dto.DoctorDto;
import com.HospitalMangagmentSystem.demo.Dto.DoctorvisitDto;
import com.HospitalMangagmentSystem.demo.Service.DoctorService;
import com.HospitalMangagmentSystem.demo.Service.DoctorvisitService;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
	import com.HospitalMangagmentSystem.demo.repository.DoctorVisitRepository;

	@RestController
	public class DoctorvisitController {

		@Autowired
		DoctorvisitService docvisitservice;
		
		@GetMapping("/DoctorsVisit")
		public List<DoctorsVisit> getDoctorsVisit(){
		
			return this.docvisitservice.getallcity();
			}
		
		@PostMapping("/DoctorsVisit/")
		//@Transactional
		public ResponseEntity<Object> createDoctorsVisit(@RequestBody DoctorvisitDto docvisit ) {
		    DoctorsVisit docvissave =this.docvisitservice.createdoctorvisit(docvisit);
			URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(docvissave.getDoctor_Visits_ID()).toUri();
			return ResponseEntity.created(location).build();
			
			
			
		}
		
		@GetMapping("/Doctorv/{id}")
		@Transactional
		public DoctorsVisit getDoctorsVisit( @PathVariable int id) 
		{
			
			return this.docvisitservice.getonedoctorvisit(id);
			
			
		}
		
		@DeleteMapping("/DoctorsVisit/{id}")
		@Transactional
		public void deleteDoctorsVisit( @PathVariable int id) {
			this.docvisitservice.deletedoctorvisit(id);
			
		}
		
		@PutMapping("/DoctorsVisit/{id}")
		@Transactional
		public DoctorsVisit updateDoctorsVisit(@RequestBody DoctorvisitDto docvisit , @PathVariable int id) {
			
			
			
			return this.docvisitservice.ubdatedoctorvisit(docvisit, id);
			
		}
		


	}


