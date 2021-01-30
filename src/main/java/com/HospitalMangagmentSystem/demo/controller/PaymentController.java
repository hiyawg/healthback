package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.PaymentDto;

import com.HospitalMangagmentSystem.demo.Service.PaymentService;

import com.HospitalMangagmentSystem.demo.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService payservice;

    @GetMapping("/Payment")
    public List<Payment> getpayment(){

        return this.payservice.getpayments();
    }

    @PostMapping("/payment/")
    @Transactional
    public ResponseEntity<Object> createpayment(@RequestBody PaymentDto paydto) {
        Payment paysave =this.payservice.createpayment(paydto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(paysave.getPayment_id()).toUri();
        return ResponseEntity.created(location).build();


    }

    @GetMapping("/payment/{id}")
    @Transactional
    public Payment getonepayment( @PathVariable int id) {

        return this.payservice.getpayment(id);

    }

    @DeleteMapping("/payment/{id}")
    @Transactional
    public void deletepatient(@RequestBody PaymentDto paydto , @PathVariable int id) {
        this.payservice.deletepayment(id);


    }

    @PutMapping("/payment/{id}")
    @Transactional
    public Payment updatepatient(@RequestBody PaymentDto paydto , @PathVariable int id) {
        return this.payservice.ubdatepatienttreat(paydto, id);


    }




}




