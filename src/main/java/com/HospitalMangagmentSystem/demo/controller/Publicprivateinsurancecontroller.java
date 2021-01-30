package com.HospitalMangagmentSystem.demo.controller;

import java.net.URI;
import java.security.PublicKey;
import java.util.List;

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

import com.HospitalMangagmentSystem.demo.Service.PublicprivateinsuranceService;
import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;
import com.HospitalMangagmentSystem.demo.repository.PublicorprivateinsuranceRepository;

@RestController
public class Publicprivateinsurancecontroller {
	@Autowired
	PublicprivateinsuranceService insuranceservice;
	
	@GetMapping("/insurance")
	public List<Publicorprivateinsurance> getallinsurance() {
		return insuranceservice.getallinsurance();
		
	}
	@PostMapping("/insurance")
	
	public ResponseEntity<Object> createinsurance(@RequestBody Publicorprivateinsurance insurance) {
		Publicorprivateinsurance insureancesave = this.insuranceservice.createinsurance(insurance);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(insureancesave.getPublic_or_private_insurance_Code()).toUri();
		return ResponseEntity.created(location).build();
	
	}
	@DeleteMapping("/insurance")
	
	public void deleteinsurance(@PathVariable String id) {
		this.insuranceservice.deleteinsurance(id);
	}

	@PutMapping("/insurance")
	public Publicorprivateinsurance updateinsurance(@RequestBody Publicorprivateinsurance insurance, @PathVariable String id) {
		
		return this.updateinsurance(insurance, id);
	}
}
