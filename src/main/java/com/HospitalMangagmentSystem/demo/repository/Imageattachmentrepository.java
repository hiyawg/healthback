package com.HospitalMangagmentSystem.demo.repository;

import java.util.List;

import com.HospitalMangagmentSystem.demo.domain.ImageAttachment;
import com.HospitalMangagmentSystem.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Imageattachmentrepository extends JpaRepository<User, Integer> {
               ImageAttachment  findUserById(int id);
}
