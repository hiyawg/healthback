package com.HospitalMangagmentSystem.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.HospitalMangagmentSystem.demo.Service.AddresService;
import com.HospitalMangagmentSystem.demo.domain.Address;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
  @Autowired
     AddresService addservice;
	
	 @GetMapping("/Address")
	    public List<Address> getAddress ()   {

	        return this.addservice.getallAddress();
	 }
	 
	 
	 
	 @GetMapping("/Address/{id}")
	    public Address getUserAddressByid(@PathVariable int id, @RequestBody Address Address ){
	        
               return  addservice.getoneAddreess(id);
	 }
	 @PostMapping("/Address/")
     @Transactional
     public void createUserAddress( @RequestBody Address Add){
                            
          this.addservice.createAddress(Add);
        
     }

	 	 
	 @PutMapping("/Address/{id}")
     public Address updateAddress(@PathVariable int id, @RequestBody Address add){ 
		

        return this.addservice.ubdateAddress(add, id);
}
	 @DeleteMapping("/Address/{id}")
	    public void deleteUserAddress(@PathVariable int id){

	        this.addservice.deleteAddress(id);
	        }	 

	 
	 
}