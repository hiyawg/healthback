package com.HospitalMangagmentSystem.demo.controller;



import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.HospitalMangagmentSystem.demo.Dto.RefmedicationDto;
import com.HospitalMangagmentSystem.demo.Service.RefmedicationService;
import com.HospitalMangagmentSystem.demo.domain.Refmedication;
import com.HospitalMangagmentSystem.demo.repository.RefmedicationRepository;

	

	@RestController

	public class RefmedicationController {
		
		@Autowired
		RefmedicationService medservice;
		
		@GetMapping("/refmedication")
	        
                public List<Refmedication> getRefMedication() {
			return this.medservice.getallmedication();
			
		}
		@RequestMapping(value = "/ref", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

		public ResponseEntity<Object> createrefmedicationnam(@RequestBody Refmedication medication) {
			
			Refmedication medsave = this.medservice.createmedication(medication);
			URI location = ServletUriComponentsBuilder
		            .fromCurrentRequest()
		            .path("/{id}")
		            .buildAndExpand(medsave.getMedicationcode()).toUri();
			return ResponseEntity.created(location).build();
		}
		@GetMapping("/refmedication/{id}")
		@Transactional

		public Refmedication getonerefmedication(@RequestBody Refmedication medication , @PathVariable int id) {
			
			return this.getonerefmedication(medication, id);
			
		}
		@DeleteMapping("/refmedication/{id}")
		@Transactional

		public void delete(@RequestBody Refmedication medication , @PathVariable int id) {
			 this.medservice.deletemedicatin(id);
		}
		
		@PutMapping("/refmedication/{id}")
		@Transactional

		public Refmedication updaterefmedication(@RequestBody Refmedication medication , @PathVariable int id) {
		return this.medservice.ubdatemedication(medication, id);
		}
	}




