package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Publicorprivateinsurance;



@Repository
public interface PublicorprivateinsuranceRepository extends JpaRepository<Publicorprivateinsurance, String> {

}
