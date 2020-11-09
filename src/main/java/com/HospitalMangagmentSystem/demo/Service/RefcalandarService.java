package com.HospitalMangagmentSystem.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Refcalendar;

@Service
public interface RefcalandarService {
	List<Refcalendar> getallcalendar();
	   
	Refcalendar getonecalendar(Date id);
	   
	Refcalendar createcalendar(Refcalendar refcal);
	   
	   void deletecalendar(Date id);
	   
	   Refcalendar ubdatecalendar(Refcalendar refcal , Date id);

	

}
