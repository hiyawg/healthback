package com.HospitalMangagmentSystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Refsurgery;



@Repository
public interface RefsurgeryReposirtory extends JpaRepository<Refsurgery, Integer> {

}
