package com.HospitalMangagmentSystem.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public void createcountryname(@RequestBody Countries cc) {
		this.couservice.createcountry(cc);
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
	public Countries updatecountry(@RequestBody Countries cc, @PathVariable int id) {
	return this.couservice.ubdatecountry(cc, id);
	}
}

