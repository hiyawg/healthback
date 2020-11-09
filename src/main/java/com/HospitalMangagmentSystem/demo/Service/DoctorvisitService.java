package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;

@Service
public interface DoctorvisitService {
	List<DoctorsVisit> getallcity();
	   
	DoctorsVisit getonedoctorvisit(int id);
	   
	DoctorsVisit createdoctorvisit(DoctorsVisit docv);
	   
	   void deletedoctorvisit(int id);
	   
	   DoctorsVisit ubdatedoctorvisit(DoctorsVisit docv , int id);

}
