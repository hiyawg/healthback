package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.repository.PatientRepository;

@Component
public class PatientserviceImplementation implements PatientService {
     @Autowired
     PatientRepository patrep;
	@Override
	public List<Patients> getallpatient() {
		// TODO Auto-generated method stub
		return patrep.findAll();
	}

	@Override
	public Patients getonepatient(int id) {
		// TODO Auto-generated method stub
		Patients pp=patrep.findById(id).orElse(null);
		  
		return pp;
	}

	@Override
	public Patients createpatient(Patients pati) {
		// TODO Auto-generated method stub
		pati.setDate_Of_Birth(pati.getDate_Of_Birth());
		
		pati.setOther_Details(pati.getOther_Details());
		return patrep.save(pati);
		
	}

	@Override
	public void deletepatient(int id) {
		// TODO Auto-generated method stub
		patrep.deleteById(id);
	}

	@Override
	public Patients ubdatepatient(Patients pati, int id) {
		// TODO Auto-generated method stub
		 pati=patrep.findById(id).orElse(null);
		pati.setDate_Of_Birth(pati.getDate_Of_Birth());
		pati.setOther_Details(pati.getOther_Details());
		return pati;
	}

}
