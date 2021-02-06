package com.HospitalMangagmentSystem.demo.Dto;

import com.HospitalMangagmentSystem.demo.domain.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private String username;
    private Set<Role> roles = new HashSet<>();


    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
