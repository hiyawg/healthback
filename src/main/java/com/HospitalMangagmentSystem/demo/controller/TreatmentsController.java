package com.HospitalMangagmentSystem.demo.controller;

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
import org.springframework.web.bind.annotation.*;

@RestController
public class TreatmentsController {
    @Autowired
    TreatmentService treatmentservice;
   
    public List<Treatments> gettreatment() {
        return this.treatmentservice.getalltratment();

    }

    @GetMapping("/Treatment/{id}")
    @Transactional
    public Treatments treatmentbyid(@PathVariable int id) {
         
          return this.treatmentservice.getonetreatment(id);
    }
    @PostMapping("/Treatment/{ch}/{chr}")
    @Transactional
    public void postTreatment(@RequestBody Treatments treat) {
       

        this.treatmentservice.createtreatment(treat);

    }
    @DeleteMapping("/Treatment/{id}")
    @Transactional
    public void delete( @PathVariable int id) {
        this.treatmentservice.deletetreatment(id);
    }

    @PutMapping("/Treatment/{id}")
    @Transactional
    public Treatments updatetreatments(@RequestBody Treatments treat , @PathVariable int id) {
       
        return this.treatmentservice.ubdatetreatment(treat, id);
    }

}
