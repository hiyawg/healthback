package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;

@Service
public interface PublicprivateinsuranceService {
	
	List<Publicorprivateinsurance> getallinsurance();
	   
	Publicorprivateinsurance getoneinsurance(String id);
	   
	Publicorprivateinsurance createinsurance(Publicorprivateinsurance insurance);
	   
	   void deleteinsurance(String id);
	   
	   Publicorprivateinsurance ubdateinsurance(Publicorprivateinsurance insurance , String id);

}
