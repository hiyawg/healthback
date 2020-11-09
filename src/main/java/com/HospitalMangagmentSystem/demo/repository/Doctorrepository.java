package com.HospitalMangagmentSystem.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Doctor;


@Repository
public interface Doctorrepository extends JpaRepository<Doctor, Integer> {

}
