package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Sideeffectscores;
import com.HospitalMangagmentSystem.demo.repository.SideeffectRepository;

@Component
public class SideeffectserviceImplementation implements SideeffectscoreService{
     @Autowired
     SideeffectRepository siderepo;
	@Override
	public List<Sideeffectscores> getallsideeffect() {
		// TODO Auto-generated method stub
		return siderepo.findAll();
	}

	@Override
	public Sideeffectscores getonesideeffect(int id) {
		// TODO Auto-generated method stub
		Sideeffectscores side=siderepo.findById(id).orElseThrow(()->
				new DataNotFoundException("side effect with id " + id + " not found") );
		return side;
	}

	@Override
	public Sideeffectscores createsideeeffect(Sideeffectscores side) {
		// TODO Auto-generated method stub
		side.setSide_Effect_Score(side.getSide_Effect_Score());
		return siderepo.save(side);
	}

	@Override
	public void deletesideeffect(int id) {
		// TODO Auto-generated method stub
		siderepo.deleteById(id);
	}

	@Override
	public Sideeffectscores ubdatesideeffect(Sideeffectscores side, int id) {
		// TODO Auto-generated method stub
		side=siderepo.findById(id).orElseThrow(()->
				new DataNotFoundException("side effect with id " + id + " not found") );
		side.setSide_Effect_Score(side.getSide_Effect_Score());
		return side;
	}

}
