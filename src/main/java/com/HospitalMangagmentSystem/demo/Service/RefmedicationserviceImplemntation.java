package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Refmedication;
import com.HospitalMangagmentSystem.demo.repository.RefmedicationRepository;

@Component
public class RefmedicationserviceImplemntation implements RefmedicationService{
    @Autowired
    RefmedicationRepository medicationrep;
	@Override
	public List<Refmedication> getallmedication() {
		// TODO Auto-generated method stub
		return medicationrep.findAll() ;
	}

	@Override
	public Refmedication getonemedication(int id) {
		// TODO Auto-g menerated method stub
		Refmedication medication=medicationrep.findById(id).orElseThrow(()->
				new DataNotFoundException("medication type with id " + id + " not found") );
		return medication;
	}

	@Override
	public Refmedication createmedication(Refmedication medication) {
		// TODO Auto-generated method stub
		medication.setMedicationname(medication.getMedicationname());
		medication.setMedicatiodescription(medication.getMedicatiodescription());
		return medicationrep.save(medication);
	}

	@Override
	public void deletemedicatin(int id) {
		// TODO Auto-generated method stub
		medicationrep.deleteById(id);
	}

	@Override
	public Refmedication ubdatemedication(Refmedication medication, int id) {
		// TODO Auto-generated method stub
		medication=medicationrep.findById(id).orElseThrow(()->
				new DataNotFoundException("medication type with id " + id + " not found") );
		medication.setMedicationname(medication.getMedicationname());
		medication.setMedicatiodescription(medication.getMedicatiodescription());
		return medication;
	}

}
