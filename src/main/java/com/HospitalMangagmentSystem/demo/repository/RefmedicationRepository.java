package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Refmedication;


@Repository
public interface RefmedicationRepository extends JpaRepository<Refmedication, Integer> {

}
