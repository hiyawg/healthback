package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.domain.Address;
import com.HospitalMangagmentSystem.demo.repository.AddressRepository;
@Component
public class AddressserviceImplementationn implements AddresService{
      @Autowired
      AddressRepository addrep;
      
	@Override
	public List<Address> getallAddress() {
		// TODO Auto-generated method stub
		
		return this.addrep.findAll();
	}

	@Override
	public Address getoneAddreess(int id) {
		// TODO Auto-generated method stub
		Address aa=addrep.findById(id).orElse(null);
		    
		return aa;
	}

	@Override
	public Address createAddress(Address add) {
		// TODO Auto-generated method stub
		add.setAddress_detail(add.getAddress_detail());
		return addrep.save(add);
	}

	@Override
	public void deleteAddress(int id) {
		addrep.deleteById(id);
		
	}

	@Override
	public Address ubdateAddress(Address add, int id) {
		// TODO Auto-generated method stub
		add=addrep.findById(id).orElse(null);
		add.setAddress_detail(add.getAddress_detail());
		return add;
	}

}
