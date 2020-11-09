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

import com.HospitalMangagmentSystem.demo.Dto.CityDto;

import com.HospitalMangagmentSystem.demo.Dto.SideeffectscoreDto;
import com.HospitalMangagmentSystem.demo.Service.SideeffectscoreService;
import com.HospitalMangagmentSystem.demo.domain.Sideeffectscores;
import com.HospitalMangagmentSystem.demo.repository.CityRepository;

import com.HospitalMangagmentSystem.demo.repository.SideeffectRepository;

@RestController
public class Sideeffectscorecontroller {     
	
	@Autowired
	SideeffectscoreService effectservice;
	
	 @GetMapping("/SideEffectScore")
	    public List<Sideeffectscores> getSideEffectScore ()   {

	        return this.effectservice.getallsideeffect();
	 }
	 
	 
	 
	 @GetMapping("/SideEffectScore/{id}")
	    public Sideeffectscores getUserSideEffectScoreByid(@PathVariable int id ){
		 
               return this.effectservice.getonesideeffect(id);
	 }
	 @PostMapping("/SideEffectScore")
     @Transactional
     public void createSideEffectScore(@RequestBody Sideeffectscores effect){

		this.effectservice.createsideeeffect(effect);
        
     }

	 	 
	 @PutMapping("/SideEffectScore/{id}")
     public Sideeffectscores updateSideEffectScore(@PathVariable int id, @RequestBody Sideeffectscores effect){ 
		

        return this.effectservice.ubdatesideeffect(effect, id);
}
	 
	 
	 
	 @DeleteMapping("/SideEffectScore/{id}")
	    public void deleteUserSideEffectScore(@PathVariable int id){

	        this.effectservice.deletesideeffect(id);
	        }	 

	 
	 

	
	
	
	

}

	
	



