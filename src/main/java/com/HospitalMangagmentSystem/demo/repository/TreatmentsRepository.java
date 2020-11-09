package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Treatments;

@Repository
public interface TreatmentsRepository extends JpaRepository<Treatments, Integer> {

}
