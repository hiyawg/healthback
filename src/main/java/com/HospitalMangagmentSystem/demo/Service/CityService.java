package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.HospitalMangagmentSystem.demo.domain.Cites;

@Service
public interface CityService {
	List<Cites> getallcity();
	   
	Cites getonecity(int id);
	   
	Cites createcity(Cites cit);
	   
	   void deletecity(int id);
	   
	   Cites ubdatecity(Cites cit , int id);
	}


