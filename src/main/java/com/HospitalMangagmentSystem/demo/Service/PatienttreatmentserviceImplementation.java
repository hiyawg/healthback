package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;
import com.HospitalMangagmentSystem.demo.repository.PatienttreatmentRepository;

@Component
public class PatienttreatmentserviceImplementation implements PatienttreatmentService{
    @Autowired
    PatienttreatmentRepository patreatrep;
	@Override
	public List<Patientstreatments> getallpatienttreat() {
		// TODO Auto-generated method stub
		return patreatrep.findAll();
	}

	@Override
	public Patientstreatments getonepatienttreat(int id) {
		// TODO Auto-generated method stub
		Patientstreatments pt=patreatrep.findById(id).orElse(null);
		
		return pt;
	}

	@Override
	public Patientstreatments createpatienttreat(Patientstreatments pt) {
		// TODO Auto-generated method stub
		pt.setOther_Details(pt.getOther_Details());
		return patreatrep.save(pt);
	}

	@Override
	public void deletepatienttreat(int id) {
		// TODO Auto-generated method stub
		patreatrep.deleteById(id);
		
	}

	@Override
	public Patientstreatments ubdatepatienttreat(Patientstreatments pt, int id) {
		// TODO Auto-generated method stub
		pt=patreatrep.findById(id).orElse(null);
		pt.setOther_Details(pt.getOther_Details());
		return pt;
	}

}
