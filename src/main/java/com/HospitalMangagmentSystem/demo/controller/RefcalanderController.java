package com.HospitalMangagmentSystem.demo.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalMangagmentSystem.demo.Service.RefcalandarService;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.repository.RefcalendarRepository;



@RestController
public class RefcalanderController {
	@Autowired
	RefcalandarService calanderservice;
	
	@GetMapping("/refcalendar")
	 public List<Refcalendar> getallcalander(){
		
		return calanderservice.getallcalendar();
		}
	@PostMapping("/refcalendar")
	@Transactional
	public void createcalenar(@RequestBody Refcalendar refcal) 
	{
		this.calanderservice.createcalendar(refcal);
	}
	
	@DeleteMapping("/refcalendar")

	public void deleteinsurance(@PathVariable Date id) {
		this.calanderservice.deletecalendar(id);
	}

	

}
