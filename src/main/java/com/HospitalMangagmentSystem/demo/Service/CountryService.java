package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Cites;
import com.HospitalMangagmentSystem.demo.domain.Countries;

@Service
public interface CountryService {
	List<Countries> getallcountry();
	   
	Countries getonecountry(int id);
	   
	Countries createcountry(Countries count);
	   
	   void deletecountry(int id);
	   
	   Countries ubdatecountry(Countries count , int id);
	}


