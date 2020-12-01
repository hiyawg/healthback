package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Refsurgery;
import com.HospitalMangagmentSystem.demo.repository.RefsurgeryReposirtory;

@Component
public class RefsurgeryImpementation implements RefsurgeryService{
   @Autowired
   RefsurgeryReposirtory surgeryrep;
	@Override
	public List<Refsurgery> getallsurgery() {
		// TODO Auto-generated method stub
		return surgeryrep.findAll();
	}

	@Override
	public Refsurgery getonesurgery(int id) {
		// TODO Auto-generated method stub
		Refsurgery surgery=surgeryrep.findById(id).orElseThrow(()->
				new DataNotFoundException("suregery with id " + id + " not found") );
		return surgery;
	}

	@Override
	public Refsurgery createsurgery(Refsurgery surgery) {
		// TODO Auto-generated method stub
		surgery.setSurgery_Name(surgery.getSurgery_Name());
		surgery.setSurgery_Description(surgery.getSurgery_Description());
		
		return surgeryrep.save(surgery);
	}

	@Override
	public void deletesurgery(int id) {
		// TODO Auto-generated method stub
		this.surgeryrep.deleteById(id);
	}

	@Override
	public Refsurgery ubdatesurgery(Refsurgery surgery, int id) {
		// TODO Auto-generated method stub
		surgery=surgeryrep.findById(id).orElseThrow(()->
				new DataNotFoundException("suregery with id " + id + " not found") );
		surgery.setSurgery_Name(surgery.getSurgery_Name());
		surgery.setSurgery_Description(surgery.getSurgery_Description());
		return surgery;
	}

}
