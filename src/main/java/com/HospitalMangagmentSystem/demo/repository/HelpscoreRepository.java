package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Helpscore;


@Repository
public interface HelpscoreRepository extends JpaRepository<Helpscore, Integer> {

}
