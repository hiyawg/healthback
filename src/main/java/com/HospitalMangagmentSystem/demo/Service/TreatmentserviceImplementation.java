package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Treatments;
import com.HospitalMangagmentSystem.demo.repository.TreatmentsRepository;

@Component
public class TreatmentserviceImplementation implements TreatmentService{
     @Autowired
     TreatmentsRepository treatrep;
	@Override
	public List<Treatments> getalltratment() {
		// TODO Auto-generated method stub
		return treatrep.findAll();
	}

	@Override
	public Treatments getonetreatment(int id) {
		// TODO Auto-generated method stub
		Treatments treat=treatrep.findById(id).orElse(null);
		return treat;
	}

	@Override
	public Treatments createtreatment(Treatments treat) {
		// TODO Auto-generated method stub
		treat.setOtherdetails(treat.getOtherdetails());
		treat.setTreatmentcost(treat.getTreatmentcost());
		treat.setMedicationorsugery(treat.getMedicationorsugery());
		return treatrep.save(treat);
	}

	@Override
	public void deletetreatment(int id) {
		// TODO Auto-generated method stub
		treatrep.deleteById(id);
	}

	@Override
	public Treatments ubdatetreatment(Treatments treat, int id) {
		// TODO Auto-generated method stub
		treat=treatrep.findById(id).orElse(null);
		treat.setOtherdetails(treat.getOtherdetails());
		treat.setTreatmentcost(treat.getTreatmentcost());
		treat.setMedicationorsugery(treat.getMedicationorsugery());
		return treat;
	}

}
