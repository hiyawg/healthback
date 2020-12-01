package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.HospitalMangagmentSystem.demo.Dto.DoctorDto;
import com.HospitalMangagmentSystem.demo.domain.Address;
import com.HospitalMangagmentSystem.demo.domain.Doctor;
import com.HospitalMangagmentSystem.demo.repository.AddressRepository;
import com.HospitalMangagmentSystem.demo.repository.Doctorrepository;
@Component
public class DoctorserviceImplementation implements DoctorService {
       @Autowired
       Doctorrepository docrep;
       @Autowired
       AddressRepository addrep;
       
	@Override
	public List<Doctor> getalldoctor() {
		// TODO Auto-generated method stub
		return docrep.findAll();
	}

	@Override
	public Doctor getonedoctor(int id) {
		// TODO Auto-generated method stub
		Doctor doc =docrep.findById(id).orElseThrow(()->
				new DataNotFoundException("doctor with id " + id + " not found") );
		
		return doc;
	}

	@Override
	@Transactional
	public Doctor createdoctor(DoctorDto doc) {
		// TODO Auto-generated method stub
		
		/*Address add = new Address();
		add.setAddress_detail(doc.getAddressdetail());*/
		
		Doctor dd = new Doctor();
		
		dd.setDoctor_Details(doc.getDoctordetails());
		
		//dd.addAdreess(add);
		return this.docrep.save(dd);
		
	}

	@Override
	public void deletedoctor(int id) {
		// TODO Auto-generated method stub
		docrep.deleteById(id);
		
	}

	@Override
	public Doctor ubdatedoctor(Doctor doc, int id) {
		// TODO Auto-generated method stub
		doc=docrep.findById(id).orElseThrow(()->
				new DataNotFoundException("doctor with id " + id + " not found") );
		doc.setDoctor_Details(doc.getDoctor_Details());
		return docrep.save(doc);
	}

}
