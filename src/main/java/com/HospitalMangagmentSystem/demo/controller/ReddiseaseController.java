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

import com.HospitalMangagmentSystem.demo.Service.RefdiseaseService;
import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;
import com.HospitalMangagmentSystem.demo.domain.Refdiseases;
import com.HospitalMangagmentSystem.demo.repository.Refdiseasesrepository;

@RestController
public class ReddiseaseController {
	@Autowired
	RefdiseaseService diseaseservice;
	
	@GetMapping("/refdis")
	
	public List<Refdiseases> getallrefdisease() {
		return this.getallrefdisease();
	}
	
	@PostMapping("/refdis")
	@Transactional
	public void createrefdisese(@RequestBody Refdiseases refdise) {
	this.diseaseservice.createdisease(refdise);
}
@DeleteMapping("/refdis")
	
	public void deleteinsurance(@PathVariable String id) {
		this.diseaseservice.deletedisease(id);
	}

	@PutMapping("/refdis")
	public Refdiseases updatedisease(@RequestBody Refdiseases refdise, @PathVariable String id) {
		
		return this.diseaseservice.ubdatedisease(refdise, id);
	}
}
	
	
	
	
	
	
	
	