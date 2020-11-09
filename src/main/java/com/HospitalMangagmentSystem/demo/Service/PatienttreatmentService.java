package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;


@Service
public interface PatienttreatmentService {
	List<Patientstreatments> getallpatienttreat();
	   
	Patientstreatments getonepatienttreat(int id);
	   
	Patientstreatments createpatienttreat(Patientstreatments pt);
	   
	   void deletepatienttreat(int id);
	   
	   Patientstreatments ubdatepatienttreat(Patientstreatments pt , int id);
}

