package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Doctor;
import com.HospitalMangagmentSystem.demo.repository.Doctorrepository;
@Component
public class DoctorserviceImplementation implements DoctorService {
       @Autowired
       Doctorrepository docrep;
	@Override
	public List<Doctor> getalldoctor() {
		// TODO Auto-generated method stub
		return docrep.findAll();
	}

	@Override
	public Doctor getonedoctor(int id) {
		// TODO Auto-generated method stub
		Doctor doc =docrep.findById(id).orElse(null);
		
		return doc;
	}

	@Override
	public Doctor createdoctor(Doctor doc) {
		// TODO Auto-generated method stub
		doc.setDoctor_Details(doc.getDoctor_Details());
		return docrep.save(doc);
	}

	@Override
	public void deletedoctor(int id) {
		// TODO Auto-generated method stub
		docrep.deleteById(id);
		
	}

	@Override
	public Doctor ubdatedoctor(Doctor doc, int id) {
		// TODO Auto-generated method stub
		doc=docrep.findById(id).orElse(null);
		doc.setDoctor_Details(doc.getDoctor_Details());
		return docrep.save(doc);
	}

}
