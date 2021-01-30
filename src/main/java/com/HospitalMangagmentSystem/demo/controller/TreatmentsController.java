package com.HospitalMangagmentSystem.demo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import com.HospitalMangagmentSystem.demo.Dto.Treatmentdto;
import com.HospitalMangagmentSystem.demo.Service.TreatmentService;
import com.HospitalMangagmentSystem.demo.domain.Refmedication;
import com.HospitalMangagmentSystem.demo.domain.Refsurgery;
import com.HospitalMangagmentSystem.demo.domain.Treatments;
import com.HospitalMangagmentSystem.demo.repository.RefmedicationRepository;
import com.HospitalMangagmentSystem.demo.repository.RefsurgeryReposirtory;
import com.HospitalMangagmentSystem.demo.repository.TreatmentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TreatmentsController {
    @Autowired
    TreatmentService treatmentservice;
   
    @GetMapping("/Treatment/")
    public List<Treatments> gettreatment() {
        return this.treatmentservice.getalltratment();

    }

    @GetMapping("/Treatment/{id}")
    @Transactional
    public Treatments treatmentbyid(@PathVariable int id) {
         
          return this.treatmentservice.getonetreatment(id);
    }
    @PostMapping("/Treatment/")
    @Transactional
    public  ResponseEntity<Object> postTreatment(@RequestBody Treatmentdto treat) {
       

       Treatments savetreat = this.treatmentservice.createtreatment(treat);
       URI location = ServletUriComponentsBuilder
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(savetreat.getTreatmentid()).toUri();
		return ResponseEntity.created(location).build();

    }
    @DeleteMapping("/Treatment/{id}")
    @Transactional
    public void delete( @PathVariable int id) {
        this.treatmentservice.deletetreatment(id);
    }

    @PutMapping("/Treatment/{id}")
    @Transactional
    public Treatments updatetreatments(@RequestBody Treatmentdto treat , @PathVariable int id) {
       
        return this.treatmentservice.ubdatetreatment(treat, id);
    }

}
