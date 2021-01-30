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

import com.HospitalMangagmentSystem.demo.Dto.CountriesDto;
import com.HospitalMangagmentSystem.demo.Service.CountryService;
import com.HospitalMangagmentSystem.demo.domain.Countries;
import com.HospitalMangagmentSystem.demo.repository.CountryRepository;
;



@RestController

public class CountriesController {
	
	@Autowired
	CountryService couservice;
	
	
	@GetMapping("/country/")
   public List<Countries> getcontry() {
		return this.couservice.getallcountry();
		
	}
	@PostMapping("/country/")
	@Transactional
	public  ResponseEntity<Object> createcountryname(@RequestBody Countries cc) {
		Countries countrysave = this.couservice.createcountry(cc);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(countrysave.getCountry_Code()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/country/{id}")
	@Transactional
	public Countries getonecountry(@RequestBody Countries cc , @PathVariable int id) {
		
		return couservice.getonecountry(id);
		
	}
	@DeleteMapping("/country/{id}")
	@Transactional
	public void delete(@RequestBody Countries cc , @PathVariable int id) {
		this.couservice.deletecountry(id);
	}
	
	@PutMapping("/country/{id}")
	@Transactional
	public Countries updatecountry(@RequestBody CountriesDto cc, @PathVariable int id) {
	return this.couservice.ubdatecountry(cc, id);
	}
}

