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

import com.HospitalMangagmentSystem.demo.Dto.HelpscoreDto;
import com.HospitalMangagmentSystem.demo.Service.HelpscoreService;
import com.HospitalMangagmentSystem.demo.domain.Helpscore;

import com.HospitalMangagmentSystem.demo.repository.HelpscoreRepository;


	@RestController
	public class Helpscorecontroller {   
		

		@Autowired
		HelpscoreService helpservice;
		
		 @GetMapping("/HelpScore")
		    public List<Helpscore> getHelpScore ()   {

		        return this.helpservice.getallhelpscore();  
		 }
		 
		 
		 
		 @GetMapping("/HelpScore/{id}")
		    public Helpscore getUserHelpScoreByid(@PathVariable int id ){
			 
	               return this.helpservice.getonehelpscore(id);
		 }
		 @PostMapping("/HelpScore")
	     @Transactional
	     public ResponseEntity<Object> createHelpScore(@RequestBody HelpscoreDto help){
			 Helpscore helpsave= this.helpservice.createhelpscore(help);
			 URI location = ServletUriComponentsBuilder
		                .fromCurrentRequest()
		                .path("/{id}")
		                .buildAndExpand(helpsave.getHelp_Score()).toUri();
				return ResponseEntity.created(location).build();
				
	        
	     }

		 	 
		 @PutMapping("/HelpScore/{id}")
	     public Helpscore updateHelpScore(@PathVariable int id, @RequestBody HelpscoreDto help ){ 
			 

	        return this.helpservice.ubdatehelpscore(help, id);
	}
		 
		 
		 
		 @DeleteMapping("/HelpScore/{id}")
		    public void deleteUserHelpScore(@PathVariable int id){

		      this.helpservice.deletehelpscore(id);
		        }	 

		
		
		
		

	}



