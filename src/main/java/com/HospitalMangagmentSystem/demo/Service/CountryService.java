package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Dto.CountriesDto;
import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Cites;
import com.HospitalMangagmentSystem.demo.domain.Countries;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Service
@JsonDeserialize
public interface CountryService {
	List<Countries> getallcountry();
	   
	Countries getonecountry(int id);
	   
	Countries createcountry(Countries count);
	   
	   void deletecountry(int id);
	   
	   Countries ubdatecountry(CountriesDto count , int id);
	}


