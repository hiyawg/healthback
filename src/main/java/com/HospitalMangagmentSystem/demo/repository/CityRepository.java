package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Cites;

@Repository
public interface CityRepository extends JpaRepository<Cites, Integer> {

}
