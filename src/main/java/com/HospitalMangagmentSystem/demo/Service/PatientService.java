package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.PatientDto;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Service
@JsonDeserialize
public interface PatientService {
	List<Patients> getallpatient();
	   
	Patients getonepatient(int id);
	   
	Patients createpatient(PatientDto pati);
	   
	   void deletepatient(int id);
	   
	   Patients ubdatepatient(PatientDto pati , int id);
}
