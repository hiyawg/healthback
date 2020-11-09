package com.HospitalMangagmentSystem.demo.repository;


import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
@Repository
public interface RefcalendarRepository extends JpaRepository<Refcalendar, Date> {

	

	

}
