package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.AddressDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.Address;
import com.HospitalMangagmentSystem.demo.domain.Cites;
import com.HospitalMangagmentSystem.demo.domain.Countries;
import com.HospitalMangagmentSystem.demo.domain.Doctor;
import com.HospitalMangagmentSystem.demo.repository.AddressRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Component
@JsonDeserialize 
public class AddressserviceImplementationn implements AddresService{
      @Autowired
      AddressRepository addrep;
      
      
	@Override
	public List<Address> getallAddress() {
		// TODO Auto-generated method stub
		
		return this.addrep.findAll();
	}

	@Override
	public Address getoneAddreess(int id) {
		// TODO Auto-generated method stub
		Address aa=addrep.findById(id).orElseThrow(()->
				new DataNotFoundException("Address with id " + id + " not found") );
		    
		return aa;
	}

	@Override
	public Address createAddress(AddressDto addto) {
		// TODO Auto-generated method stub
		Address add = new Address();
		add.setAddress_detail(addto.getaddressdetail());
		
		
	Doctor dd = new Doctor();
		
		
		dd.setDoctor_Details(addto.getDoctordetails());
		
	     add.setDoctor(dd);
		
	Countries cou = new Countries();
	       cou.setCountry_Name(addto.getCountryname());
	       add.setCountries(cou);
	       
	       Cites cc = new Cites();
	       cc.setCity_Name(addto.getCityname());
	       add.setCity(cc);
	       
		return addrep.save(add);
	}

	@Override
	public void deleteAddress(int id) {
		addrep.deleteById(id);
		
	}

	@Override
	public Address ubdateAddress(AddressDto addto, int id) {
		// TODO Auto-generated method stub
		Address add = new Address();
		add=addrep.findById(id).orElseThrow(()->
				new DataNotFoundException("Address with id " + id + " not found") );
		add.setAddress_detail(addto.getaddressdetail());
		return this.addrep.save(add);
	}

}
