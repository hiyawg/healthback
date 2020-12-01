package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.HelpscoreDto;
import com.HospitalMangagmentSystem.demo.domain.Helpscore;

@Service
public interface HelpscoreService {
	List<Helpscore> getallhelpscore();
	   
	Helpscore getonehelpscore(int id);
	   
	Helpscore createhelpscore(HelpscoreDto help);
	   
	   void deletehelpscore(int id);
	   
	   Helpscore ubdatehelpscore(HelpscoreDto help , int id);
}



