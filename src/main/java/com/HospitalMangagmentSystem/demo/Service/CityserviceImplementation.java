package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.CityDto;
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
		Cites cc=citrep.findById(id).orElseThrow(()->
				new DataNotFoundException("city with id " + id + " not found") );
		return cc;
	}

	@Override
	public Cites createcity(CityDto cit) {
		// TODO Auto-generated method stub
		Cites cc = new Cites ()	;
		cc.setCity_Name(cit.getCityname());
		return citrep.save(cc);
	}

	@Override
	public void deletecity(int id) {
		// TODO Auto-generated method stub
		this.citrep.deleteById(id);
	}

	@Override
	public Cites ubdatecity(CityDto citd, int id) {
		// TODO Auto-generated method stub
		Cites cit =citrep.findById(id).orElseThrow(()->
				new DataNotFoundException("city with id " + id + " not found") );
		
		cit.setCity_Name(citd.getCityname());
		return this.citrep.save(cit);
	}

}
