package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.HospitalMangagmentSystem.demo.repository.DoctorVisitRepository;
@Component
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
		DoctorsVisit docvi=dovisitrep.findById(id).orElse(null);
		return docvi ;
	}

	@Override
	public DoctorsVisit createdoctorvisit(DoctorsVisit docv) {
		// TODO Auto-generated method stub
		docv.setVisit_Details(docv.getVisit_Details());
		return dovisitrep.save(docv) ;
	}

	@Override
	public void deletedoctorvisit(int id) {
		// TODO Auto-generated method stub
		dovisitrep.deleteById(id);
	}

	@Override
	public DoctorsVisit ubdatedoctorvisit(DoctorsVisit docv, int id) {
		// TODO Auto-generated method stub
		docv=dovisitrep.findById(id).orElse(null);
		docv.setDoctor_Visits_ID(docv.getDoctor_Visits_ID());
		return docv;
	}

}
