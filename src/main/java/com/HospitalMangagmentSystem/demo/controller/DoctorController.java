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
import com.HospitalMangagmentSystem.demo.Service.DoctorService;
import com.HospitalMangagmentSystem.demo.domain.Doctor;

import com.HospitalMangagmentSystem.demo.repository.Doctorrepository;

@RestController
public class DoctorController {

	@Autowired
	DoctorService docservice;
	
	@GetMapping("/Doctor")
	public List<Doctor> getDoctor(){
	
		return this.docservice.getalldoctor();
	}
	
	@PostMapping("/Doctor")
	@Transactional
	public ResponseEntity<Object> createDoctor(@RequestBody DoctorDto doc) {
		Doctor docsave = this.docservice.createdoctor(doc);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(docsave.getDoctor_ID()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/Doctor/{id}")
	@Transactional
	public Doctor getoneDoctor(@RequestBody DoctorDto Doctordto , @PathVariable int id) {
		
		return docservice.getonedoctor(id);
		
		
	}
	
	@DeleteMapping("/Doctor/{id}")
	@Transactional
	public void deleteDoctor( @PathVariable int id) {
		this.docservice.deletedoctor(id);
		
	}
	
	@PutMapping("/Doctor/{id}")
	@Transactional
	public Doctor updateDoctor(@RequestBody Doctor doc , @PathVariable int id) {
		
		
		return this.docservice.ubdatedoctor(doc, id);
		
	}

}
