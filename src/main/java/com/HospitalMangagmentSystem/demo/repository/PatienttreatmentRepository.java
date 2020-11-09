package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Patientstreatments;

@Repository
public interface PatienttreatmentRepository extends JpaRepository<Patientstreatments, Integer> {

}
