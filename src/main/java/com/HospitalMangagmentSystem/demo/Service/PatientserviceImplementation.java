package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.PatientDto;
import com.HospitalMangagmentSystem.demo.domain.Address;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.domain.Refdiseases;
import com.HospitalMangagmentSystem.demo.repository.PatientRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.transaction.Transactional;

@Component
@JsonDeserialize
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
		Patients pp=patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		  
		return pp;
	}
	@Transactional
	private Patients createPatients(PatientDto patientDto) {
		Patients patient = new Patients();

		patient.setFirst(patientDto.getFirst());
		patient.setLast(patientDto.getLast());
		patient.setGender(patientDto.getGender());
		patient.setDob(patientDto.getDob());
		patient.setEmail(patientDto.getEmail());
		patient.setMobile(patientDto.getMobile());


		// address
		Address address = new Address();
		address.setAddress_detail(patientDto.getAddress());
		patient.addPatientAddress(address);

		return patient;
	}
	@Override
	public Patients createpatient(PatientDto patientDto) {
		Patients patient = createPatients(patientDto);
		return patrep.save(patient);

		
	}

	@Override
	public void deletepatient(int id) {
		// TODO Auto-generated method stub
		Patients patient = patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patrep.delete(patient);
	}

	@Override
	public Patients ubdatepatient(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setFirst(patientDto.getFirst());
		patient.setLast(patientDto.getLast());
		patient.setGender(patientDto.getGender());
		patient.setDob(patientDto.getDob());
		patient.setEmail(patientDto.getEmail());
		patient.setMobile(patientDto.getMobile());

		Address aa = new Address();
		aa.setAddress_detail(patientDto.getAddress());
		patient.addPatientAddress(aa);
		return patrep.save(patient);

	}

}
