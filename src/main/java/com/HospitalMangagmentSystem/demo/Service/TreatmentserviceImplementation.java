package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.Treatmentdto;
import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;
import com.HospitalMangagmentSystem.demo.domain.Refmedication;
import com.HospitalMangagmentSystem.demo.domain.Refsurgery;
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
		Treatments treat=treatrep.findById(id).orElseThrow(()->
				new DataNotFoundException("treatment with id " + id + " not found") );
		return treat;
	}

	@Override
	public Treatments createtreatment(Treatmentdto treatdto) {
		// TODO Auto-generated method stub
		Treatments treat = new Treatments();
		treat.setOtherdetails(treatdto.getOtherdetails());
		treat.setTreatmentcost(treatdto.getTreatmentcost());
		treat.setMedicationorsugery(treatdto.getMedicationorsugery());
		
		Refmedication medication = new Refmedication();
		medication.setMedicationname(treatdto.getMedicationname());
		medication.setMedicatiodescription(treatdto.getMedicatiodescription());
		
		treat.setMedication(medication);
		
		Refsurgery surgery = new Refsurgery();
		surgery.setSurgery_Name(treatdto.getSurgeryname());
		surgery.setSurgery_Description(treatdto.getSurgerydescription());
		 
		treat.setSurgery(surgery);
		 
	
		return treatrep.save(treat);
	}

	@Override
	public void deletetreatment(int id) {
		// TODO Auto-generated method stub
		treatrep.deleteById(id);
	}

	@Override
	public Treatments ubdatetreatment(Treatmentdto treatdto, int id) {
		// TODO Auto-generated method stub
		Treatments treat = new Treatments();
		treat=treatrep.findById(id).orElseThrow(()->
				new DataNotFoundException("treatment with id " + id + " not found") );
		treat.setOtherdetails(treatdto.getOtherdetails());
		treat.setTreatmentcost(treatdto.getTreatmentcost());
		treat.setMedicationorsugery(treatdto.getMedicationorsugery());
		return this.treatrep.save(treat);
	}

}
