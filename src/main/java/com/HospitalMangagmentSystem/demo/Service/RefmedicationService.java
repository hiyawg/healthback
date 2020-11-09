package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Refmedication;

@Service
public interface RefmedicationService {
	List<Refmedication> getallmedication();
	   
	Refmedication getonemedication(int id);
	   
	Refmedication createmedication(Refmedication medication);
	   
	   void deletemedicatin(int id);
	   
	   Refmedication ubdatemedication(Refmedication medication , int id);
}



