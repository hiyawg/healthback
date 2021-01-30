package com.HospitalMangagmentSystem.demo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.HospitalMangagmentSystem.demo.Dto.AddressDto;
import com.HospitalMangagmentSystem.demo.Service.AddresService;
import com.HospitalMangagmentSystem.demo.domain.Address;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AddressController {
  @Autowired
     AddresService addservice;
	
	 @GetMapping("/Address")
	    public List<Address> getAddress ()   {

	        return this.addservice.getallAddress();
	 }
	 
	 
	 
	 @GetMapping("/Address/{id}")
	    public Address getUserAddressByid(@PathVariable int id, @RequestBody AddressDto Address ){
	        
               return  addservice.getoneAddreess(id);
	 }
	 @PostMapping("/Address/")
     @Transactional
     public ResponseEntity<Object> createUserAddress( @RequestBody AddressDto Add){
              
		 Address aasave = this.addservice.createAddress(Add);
		URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(aasave.getAddress_id()).toUri();
		 
		 return ResponseEntity.created(location).build();
          
        
     }

	 	 
	 @PutMapping("/Address/{id}")
     public Address updateAddress(@PathVariable int id, @RequestBody AddressDto add){ 
		

        return this.addservice.ubdateAddress(add, id);
}
	 @DeleteMapping("/Address/{id}")
	    public void deleteUserAddress(@PathVariable int id){

	        this.addservice.deleteAddress(id);
	        }	 

	 
	 
}