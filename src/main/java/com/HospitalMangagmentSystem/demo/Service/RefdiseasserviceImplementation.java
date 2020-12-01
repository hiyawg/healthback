package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Refdiseases;
import com.HospitalMangagmentSystem.demo.repository.Refdiseasesrepository;

@Component
public class RefdiseasserviceImplementation implements RefdiseaseService {
     @Autowired
     Refdiseasesrepository refdiserep;
	@Override
	public List<Refdiseases> getalldisease() {
		// TODO Auto-generated method stub
		return refdiserep.findAll();
	}

	@Override
	public Refdiseases getonedisease(String id) {
		// TODO Auto-generated method stub
		Refdiseases refdise=refdiserep.findById(id).orElseThrow(()->
				new DataNotFoundException("disease type with id " + id + " not found") );
		return refdise;
	}

	@Override
	public Refdiseases createdisease(Refdiseases refdise) {
		// TODO Auto-generated method stub
		refdise.setDiease_Code(refdise.getDiease_Code());
		refdise.setDisease_Name(refdise.getDisease_Name());
		refdise.setDisease_Description(refdise.getDisease_Description());
		return refdiserep.save(refdise);
	}

	@Override
	public void deletedisease(String id) {
		// TODO Auto-generated method stub
		refdiserep.deleteById(id);
		
	}

	@Override
	public Refdiseases ubdatedisease(Refdiseases refdise, String id) {
		// TODO Auto-generated method stub
		refdise=refdiserep.findById(id).orElseThrow(()->
				new DataNotFoundException("disease type with id " + id + " not found") );
		refdise.setDiease_Code(refdise.getDiease_Code());
		refdise.setDisease_Name(refdise.getDisease_Name());
		refdise.setDisease_Description(refdise.getDisease_Description());
		return refdise;
	}

}
