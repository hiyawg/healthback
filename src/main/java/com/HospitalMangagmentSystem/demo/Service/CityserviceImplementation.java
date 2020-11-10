package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Cites;
import com.HospitalMangagmentSystem.demo.repository.CityRepository;
@Component
public class CityserviceImplementation implements CityService {
     @Autowired
     CityRepository citrep;
	@Override
	public List<Cites> getallcity() {
		// TODO Auto-generated method stub
		
		return citrep.findAll();
	}

	@Override
	public Cites getonecity(int id) {
		// TODO Auto-generated method stub
		Cites cc=citrep.findById(id).orElse(null);
		return cc;
	}

	@Override
	public Cites createcity(Cites cit) {
		// TODO Auto-generated method stub
		cit.setCiy_Code(cit.getCiy_Code());
		cit.setCity_Name(cit.getCity_Name());
		return citrep.save(cit);
	}

	@Override
	public void deletecity(int id) {
		// TODO Auto-generated method stub
		this.citrep.deleteById(id);
	}

	@Override
	public Cites ubdatecity(Cites cit, int id) {
		// TODO Auto-generated method stub
		cit=citrep.findById(id).orElse(null);
		cit.setCiy_Code(cit.getCiy_Code());
		cit.setCity_Name(cit.getCity_Name());
		return cit;
	}

}
