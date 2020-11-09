package com.HospitalMangagmentSystem.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;





@Repository
public interface DoctorVisitRepository extends JpaRepository<DoctorsVisit, Integer> {

}
