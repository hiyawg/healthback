package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.DoctorDto;
import com.HospitalMangagmentSystem.demo.domain.Doctor;



@Service
public interface DoctorService {
	List<Doctor> getalldoctor();
	   
	Doctor getonedoctor(int id);
	   
	Doctor  createdoctor(DoctorDto doc);
	   
	   void deletedoctor(int id);
	   
	   Doctor ubdatedoctor(Doctor doc , int id);
	}



