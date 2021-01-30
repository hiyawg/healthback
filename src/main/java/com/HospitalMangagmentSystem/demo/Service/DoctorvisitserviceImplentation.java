package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.DoctorvisitDto;
import com.HospitalMangagmentSystem.demo.domain.Doctor;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.repository.DoctorVisitRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Component
@JsonDeserialize 
public class DoctorvisitserviceImplentation implements DoctorvisitService {
       @Autowired
       DoctorVisitRepository dovisitrep;
	@Override
	public List<DoctorsVisit> getallcity() {
		// TODO Auto-generated method stub
		return dovisitrep.findAll();
	}

	@Override
	public DoctorsVisit getonedoctorvisit(int id) {
		// TODO Auto-generated method stub
		DoctorsVisit docvi=dovisitrep.findById(id).orElseThrow(()->
				new DataNotFoundException("doctor visit with id " + id + " not found") );
		return docvi ;
	}

	@Override
	public DoctorsVisit createdoctorvisit(DoctorvisitDto docvd) {
		// TODO Auto-generated method stub
		DoctorsVisit dv = new DoctorsVisit();
		dv.setVisit_Details(docvd.getVisitdetails());
		
		Doctor dd = new Doctor();
		 dd.setDoctor_Details(docvd.getDoctordetails());
		 
              dv.setDoctor(dd);
         
              Patients pp = new Patients();
              pp.setDateOfbirth(docvd.getDateofbirth());
              pp.setOther_Details(docvd.getOtherdetails());
              
              dv.setPatient(pp);
              
              Refcalendar rfcal = new Refcalendar();
              rfcal.setDay_Date_Time(docvd.getDaydatetime());
              rfcal.setDay_Number(docvd.getDaynumber());
            dv.setRefCalender(rfcal);
            
		return dovisitrep.save(dv) ;
	}

	@Override
	public void deletedoctorvisit(int id) {
		// TODO Auto-generated method stub
		dovisitrep.deleteById(id);
	}

	@Override
	public DoctorsVisit ubdatedoctorvisit(DoctorvisitDto docvd, int id) {
		// TODO Auto-generated method stub
		DoctorsVisit docv=dovisitrep.findById(id).orElseThrow(()->
				new DataNotFoundException("doctor visit with id " + id + " not found") );
		
		docv.setVisit_Details(docvd.getVisitdetails());
		return docv;
	}

}
