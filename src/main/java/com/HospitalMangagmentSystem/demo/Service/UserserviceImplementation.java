package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.UserDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;

import com.HospitalMangagmentSystem.demo.domain.*;
import com.HospitalMangagmentSystem.demo.message.request.SignUpForm;
import com.HospitalMangagmentSystem.demo.message.response.ResponseMessage;
import com.HospitalMangagmentSystem.demo.repository.RoleRepository;
import com.HospitalMangagmentSystem.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserserviceImplementation implements UserService{
    @Autowired
    UserRepository userep;

    @Autowired
    RoleRepository rolrep;
    @Override
    public List<User> getalluser() {
        return userep.findAll();
    }

    @Override
    public User getoneuser(int id) {
        User use=userep.findById(id).orElseThrow(()->
                new DataNotFoundException("patient with id " + id + " not found") );

        return use;
    }

    @Override
    public List<User> getbyrole() {
        Set<Role> roles = new HashSet<>();
        Role role = new  Role();
        role.setName(Rolename.ROLE_ADMIN);
        roles.add(role);
        Long l = 3L;

        return userep.findUserByRoles(rolrep.findByName(Rolename.ROLE_DOCTOR).orElse(null));
    }

    @Override
    public User updateauser(int id, SignUpForm userdto) {
        User user =userep.findById(id).orElseThrow(()->
                new DataNotFoundException("patient with id " + id + " not found") );
        user.setFirst(userdto.getFirst());
        user.setLast(userdto.getLast());
        user.setGender(userdto.getGender());
        user.setDob(userdto.getDob());
        user.setEmail(userdto.getEmail());
        user.setMobile(userdto.getMobile());
        user.setDepartment(userdto.getDepartment());
        user.setDesignation(userdto.getDesignation());
        user.setEducation(userdto.getEducation());

        userep.save(user);
        return user;
    }


    @Override
    public void delteuser(int id) {

            // TODO Auto-generated method stub
        User use=userep.findById(id).orElseThrow(()->
                new DataNotFoundException("patient with id " + id + " not found") );
            userep.delete(use);
        }



}
