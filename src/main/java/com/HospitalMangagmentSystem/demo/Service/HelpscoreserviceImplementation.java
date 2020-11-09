package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		Helpscore help=helprepo.findById(id).orElse(null);
	
		return help;
	}

	@Override
	public Helpscore createhelpscore(Helpscore help) {
		// TODO Auto-generated method stub
		help.setHelp_Score(help.getHelp_Score());
		return helprepo.save(help);
	}

	@Override
	public void deletehelpscore(int id) {
		// TODO Auto-generated method stub
		helprepo.deleteById(id);
	}

	@Override
	public Helpscore ubdatehelpscore(Helpscore help, int id) {
		// TODO Auto-generated method stub
		help=helprepo.findById(id).orElse(null);
		 help.setHelp_Score(help.getHelp_Score());
		return help;
	}

}
