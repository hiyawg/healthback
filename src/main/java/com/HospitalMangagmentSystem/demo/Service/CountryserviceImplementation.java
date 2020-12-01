package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Dto.CountriesDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Countries;
import com.HospitalMangagmentSystem.demo.repository.CountryRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Component
@JsonDeserialize
public class CountryserviceImplementation implements CountryService{
  @Autowired
  CountryRepository  courep;
	@Override
	public List<Countries> getallcountry() {
		// TODO Auto-generated method stub
		return courep.findAll();
	}

	@Override
	public Countries getonecountry(int id) {
		// TODO Auto-generated method stub
		Countries cou=courep.findById(id).orElseThrow(()->
				new DataNotFoundException("country with id " + id + " not found") );
		
		return cou;
	}

	@Override
	public Countries createcountry(Countries count) {
		// TODO Auto-generated method stub
		count.setCountry_Code(count.getCountry_Code());
		count.setCountry_Name(count.getCountry_Name());
		return courep.save(count);
	}

	@Override
	public void deletecountry(int id) {
		// TODO Auto-generated method stub
		courep.deleteById(id);
		
	}

	@Override
	public Countries ubdatecountry(CountriesDto countd, int id) {
		// TODO Auto-generated method stub
		Countries count=courep.findById(id).orElseThrow(()->
				new DataNotFoundException("country with id " + id + " not found") );

		count.setCountry_Name(countd.getCountryname());
		return courep.save(count);
	}

}
