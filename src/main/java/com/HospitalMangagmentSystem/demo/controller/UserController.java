package com.HospitalMangagmentSystem.demo.controller;


import com.HospitalMangagmentSystem.demo.Service.UserService;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserService userservice;

    @GetMapping("/User")
    public List<User> getuser(){

        return this.userservice.getalluser();
    }
    @GetMapping("/User/role")
    public List<User> getuserrole(){

        return this.userservice.getbyrole();
    }
    @GetMapping("/User/{id}")
    @Transactional
    public User getoneuser( @PathVariable int id) {

        return this.userservice.getoneuser(id);

    }
    @DeleteMapping("/User/{id}")
    @Transactional
    public void delteuser( @PathVariable int id) {
        this.userservice.delteuser(id);


    }
}
