package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.patienttreatmentDto;
import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Service
@JsonDeserialize
public interface PatienttreatmentService {
	List<Patientstreatments> getallpatienttreat();
	   
	Patientstreatments getonepatienttreat(int id);
	   
	Patientstreatments createpatienttreat(patienttreatmentDto pt);
	   
	   void deletepatienttreat(int id);
	   
	   Patientstreatments ubdatepatienttreat(patienttreatmentDto pt , int id);
}

