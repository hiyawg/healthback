package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.AddressDto;
import com.HospitalMangagmentSystem.demo.domain.Address;


@Service

public interface AddresService {
   List<Address> getallAddress();
   
   Address getoneAddreess(int id);
   
   Address createAddress(AddressDto add);
   
   void deleteAddress(int id);
   
   Address ubdateAddress(AddressDto addto , int id);
}
