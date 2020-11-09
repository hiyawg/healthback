package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Patients;


@Service
public interface PatientService {
	List<Patients> getallpatient();
	   
	Patients getonepatient(int id);
	   
	Patients createpatient(Patients pati);
	   
	   void deletepatient(int id);
	   
	   Patients ubdatepatient(Patients pati , int id);
}
