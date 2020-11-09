package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.HospitalMangagmentSystem.demo.domain.Refsurgery;

@Service
public interface RefsurgeryService {
	List<Refsurgery> getallsurgery();
	   
	Refsurgery getonesurgery(int id);
	   
	Refsurgery createsurgery(Refsurgery surgery);
	   
	   void deletesurgery(int id);
	   
	   Refsurgery ubdatesurgery(Refsurgery surgery , int id);

}
