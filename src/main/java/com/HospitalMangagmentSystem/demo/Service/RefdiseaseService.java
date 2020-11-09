package com.HospitalMangagmentSystem.demo.Service;


import java.util.List;

import org.springframework.stereotype.Service;


import com.HospitalMangagmentSystem.demo.domain.Refdiseases;

@Service
public interface RefdiseaseService {
	List<Refdiseases> getalldisease();
	   
	Refdiseases getonedisease(String id);
	   
	Refdiseases createdisease(Refdiseases refdise);
	   
	   void deletedisease(String id);
	   
	   Refdiseases ubdatedisease(Refdiseases refdise , String id);

	
}
