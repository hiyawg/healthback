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

import com.HospitalMangagmentSystem.demo.Dto.RefsurgeryDto;
import com.HospitalMangagmentSystem.demo.Service.RefsurgeryService;
import com.HospitalMangagmentSystem.demo.domain.Refsurgery;
import com.HospitalMangagmentSystem.demo.repository.RefsurgeryReposirtory;

		

		@RestController

		public class RefsurgeryCotroller {
			
			@Autowired
			RefsurgeryService surgryservice;
			
			@GetMapping("/RefSurgery/")
		        
	                public List<Refsurgery> getRefSurgery() {
				return this.surgryservice.getallsurgery();
				
			}
			@PostMapping("/refsurgery/")
			@Transactional
			public  ResponseEntity<Object> createrefsurgeryname(@RequestBody Refsurgery surgery) {
	             Refsurgery surgerysave =this.surgryservice.createsurgery(surgery);
	             URI location = ServletUriComponentsBuilder
	 		            .fromCurrentRequest()
	 		            .path("/{id}")
	 		            .buildAndExpand(surgerysave.getSurgery_Code()).toUri();
	 			return ResponseEntity.created(location).build();
			}
			@GetMapping("/refsurgery/{id}")
			@Transactional

			public Refsurgery getonerefsurgery( @PathVariable int id) {
								return this.getonerefsurgery(id);
				
			}
			@DeleteMapping("/refsurgery/{id}")
	

			public void delete(@PathVariable int id) {
				this.surgryservice.deletesurgery(id);
				 
			}
			
			@PutMapping("/refsurgery/{id}")
			@Transactional
			public Refsurgery updaterefsurgery(@RequestBody Refsurgery surgery , @PathVariable int id) {
				return this.updaterefsurgery(surgery, id);
				}
			}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

