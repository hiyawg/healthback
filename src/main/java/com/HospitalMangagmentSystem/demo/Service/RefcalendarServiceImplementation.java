package com.HospitalMangagmentSystem.demo.Service;


import java.util.Date;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
import com.HospitalMangagmentSystem.demo.repository.RefcalendarRepository;

@Component
public class RefcalendarServiceImplementation implements RefcalandarService {
    @Autowired
    RefcalendarRepository refcalrepo;
	@Override
	public List<Refcalendar> getallcalendar() {
		// TODO Auto-generated method stub
		return refcalrepo.findAll();
	}

	@Override
	public Refcalendar getonecalendar(Date id) {
		// TODO Auto-generated method stub
		Refcalendar refcal=refcalrepo.findById(id).orElseThrow(()->
				new DataNotFoundException("calendar with id " + id + " not found") );
		return refcal ;
	}

	@Override
	public Refcalendar createcalendar(Refcalendar refcal) {
		// TODO Auto-generated method stub
		refcal.setDay_Date_Time(refcal.getDay_Date_Time());
		refcal.setDay_Number(refcal.getDay_Number());
		return refcalrepo.save(refcal);
	}

	@Override
	public void deletecalendar(Date id)
	   {
		// TODO Auto-generated method stub
		refcalrepo.deleteById(id);
	}

	@Override
	public Refcalendar ubdatecalendar(Refcalendar refcal, Date id) {
		// TODO Auto-generated method stub
		refcal=refcalrepo.findById(id).orElseThrow(()->
				new DataNotFoundException("calendar with id " + id + " not found") );
		refcal.setDay_Date_Time(refcal.getDay_Date_Time());
		refcal.setDay_Number(refcal.getDay_Number());
		return refcal;
	}

	
	
}
