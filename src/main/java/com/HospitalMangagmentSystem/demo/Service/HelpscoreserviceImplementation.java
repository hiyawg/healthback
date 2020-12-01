package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.Dto.HelpscoreDto;
import com.HospitalMangagmentSystem.demo.domain.Helpscore;
import com.HospitalMangagmentSystem.demo.repository.HelpscoreRepository;

@Component
public class HelpscoreserviceImplementation implements HelpscoreService{
     @Autowired
     HelpscoreRepository helprepo;
	@Override
	public List<Helpscore> getallhelpscore() {
		// TODO Auto-generated method stub
		
		return helprepo.findAll();
	}

	@Override
	public Helpscore getonehelpscore(int id) {
		// TODO Auto-generated method stub
		Helpscore help=helprepo.findById(id).orElseThrow(()->
				new DataNotFoundException("help score with id " + id + " not found") );
	
		return help;
	}

	@Override
	public Helpscore createhelpscore(HelpscoreDto helpdto) {
		// TODO Auto-generated method stub
		Helpscore help = new Helpscore();
		help.setHelp_Score(helpdto.getHelpscore());		
		return helprepo.save(help);
	}

	@Override
	public void deletehelpscore(int id) {
		// TODO Auto-generated method stub
		helprepo.deleteById(id);
	}

	@Override
	public Helpscore ubdatehelpscore(HelpscoreDto helpdto, int id) {
		// TODO Auto-generated method stub
	Helpscore help=helprepo.findById(id).orElseThrow(()->
			new DataNotFoundException("help score with id " + id + " not found") );
		 help.setHelp_Score(helpdto.getHelpscore());
		return help;
	}

}
