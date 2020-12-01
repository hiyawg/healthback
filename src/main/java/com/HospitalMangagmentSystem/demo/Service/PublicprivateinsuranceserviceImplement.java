package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;
import com.HospitalMangagmentSystem.demo.repository.PublicorprivateinsuranceRepository;

@Component
public class PublicprivateinsuranceserviceImplement implements PublicprivateinsuranceService {
    @Autowired
    PublicorprivateinsuranceRepository insurancerep;
	@Override
	public List<Publicorprivateinsurance> getallinsurance() {
		// TODO Auto-generated method stub
		return insurancerep.findAll();
	}

	@Override
	public Publicorprivateinsurance getoneinsurance(String id) {
		// TODO Auto-generated method stub
		Publicorprivateinsurance insurance=insurancerep.findById(id).orElseThrow(()->
				new DataNotFoundException("insurance with id " + id + " not found") );
		return insurance;
	}

	@Override
	public Publicorprivateinsurance createinsurance(Publicorprivateinsurance insurance) {
		// TODO Auto-generated method stub
		insurance.setPublic_or_private_insurance_Code(insurance.getPublic_or_private_insurance_Code());
		return null;
	}

	@Override
	public void deleteinsurance(String id) {
		// TODO Auto-generated method stub
		insurancerep.deleteById(id);
	}

	@Override
	public Publicorprivateinsurance ubdateinsurance(Publicorprivateinsurance insurance, String id) {
		// TODO Auto-generated method stub
		insurance=insurancerep.findById(id).orElseThrow(()->
				new DataNotFoundException("insurance with id " + id + " not found") );
		insurance.setPublic_or_private_insurance_Code(insurance.getPublic_or_private_insurance_Code());
		return insurance;
	}

}
