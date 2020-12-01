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

import com.HospitalMangagmentSystem.demo.Dto.CityDto;
import com.HospitalMangagmentSystem.demo.Service.CityService;
import com.HospitalMangagmentSystem.demo.domain.Cites;

	import com.HospitalMangagmentSystem.demo.repository.CityRepository;

	@RestController
	public class CityController {   
		@Autowired
	    CityService citservice;
		
		 @GetMapping("/City")
		    public List<Cites> getCity ()   {

		        return this.citservice.getallcity();
		 }
		 
		 
		 
		 @GetMapping("/City/{id}")
		    public Cites getUserAddressByid(@PathVariable int id, @RequestBody Cites Cit ){
		   
	               return citservice.getonecity(id);
		 }
		 @PostMapping("/City")
	     @Transactional
	     public ResponseEntity<Object> createUserCity(@RequestBody CityDto cit){
              
			 Cites citysave = this.citservice.createcity(cit);
	            
			 URI location = ServletUriComponentsBuilder
	                 .fromCurrentRequest()
	                 .path("/{id}")
	                 .buildAndExpand(citysave.getCiy_Code()).toUri();
			 return ResponseEntity.created(location).build();
	        
	     }

		 	 
		 @PutMapping("/City/{id}")
	     public Cites updateCity(@PathVariable int id, @RequestBody CityDto cit){ 
			 
		    
	        return this.citservice.ubdatecity(cit, id);
	}
		 

}
