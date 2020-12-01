package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.DoctorvisitDto;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Service
@JsonDeserialize 
public interface DoctorvisitService {
	List<DoctorsVisit> getallcity();
	   
	DoctorsVisit getonedoctorvisit(int id);
	   
	DoctorsVisit createdoctorvisit(DoctorvisitDto docv);
	   
	   void deletedoctorvisit(int id);
	   
	   DoctorsVisit ubdatedoctorvisit(DoctorvisitDto docv , int id);

}
