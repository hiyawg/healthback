package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.HospitalMangagmentSystem.demo.domain.Sideeffectscores;

@Service
public interface SideeffectscoreService {
	
	List<Sideeffectscores> getallsideeffect();
	   
	Sideeffectscores getonesideeffect(int id);
	   
	Sideeffectscores createsideeeffect(Sideeffectscores side);
	   
	   void deletesideeffect(int id);
	   
	   Sideeffectscores ubdatesideeffect(Sideeffectscores side , int id);
}
