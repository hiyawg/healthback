package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Sideeffectscores;


@Repository
public interface SideeffectRepository extends JpaRepository<Sideeffectscores, Integer> {

}
