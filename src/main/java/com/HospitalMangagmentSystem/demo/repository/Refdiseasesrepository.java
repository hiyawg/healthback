package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Refdiseases;


@Repository
public interface Refdiseasesrepository extends JpaRepository<Refdiseases, String> {

}
