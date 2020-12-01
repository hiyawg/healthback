package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.Treatmentdto;
import com.HospitalMangagmentSystem.demo.domain.Treatments;

@Service
public interface TreatmentService {
	List<Treatments> getalltratment();
	   
	Treatments getonetreatment(int id);
	   
	Treatments createtreatment(Treatmentdto treat);
	   
	   void deletetreatment(int id);
	   
	   Treatments ubdatetreatment(Treatmentdto treat , int id);

}
