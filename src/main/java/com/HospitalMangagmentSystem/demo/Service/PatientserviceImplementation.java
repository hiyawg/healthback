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
		address.setAddress_detail(patientDto.getAddress_detail());
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
		patrep.deleteById(id);
	}

	/*@Override
	public Patients ubdatepatient(PatientDto patidto, int id) {
		// TODO Auto-generated method stub
		/*Patients pati=patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		pati.setDateOfbirth(patidto.getDateofbirth());
		pati.setOther_Details(patidto.getOtherdetails());

		Address aa = new Address();
		aa.setAddress_detail(patidto.getAddressdetail());
		pati.setAddress(aa);

		Publicorprivateinsurance insurance = new Publicorprivateinsurance();
		insurance.setPublic_or_private_insurance_Code(patidto.getPublicorprivateinsurancecode());
		pati.setPublic_or_Private_Insurance_Code(insurance);

		Refcalendar cal = new Refcalendar();
		cal.setDay_Date_Time(patidto.getDaydatetime());
		cal.setDay_Number(patidto.getDaynumber());
		pati.setDay_Date_Time(cal);

		Refdiseases dise = new Refdiseases();
		dise.setDiease_Code(patidto.getDieasecode());
		dise.setDisease_Name(patidto.getDiseasename());
		dise.setDisease_Description(patidto.getDiseasedescription());

		pati.setDisease(dise);
		
		
		return patrep.save(pati);

	}*/

}
