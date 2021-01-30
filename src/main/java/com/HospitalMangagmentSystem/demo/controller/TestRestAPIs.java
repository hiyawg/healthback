package com.HospitalMangagmentSystem.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER')	or	hasRole('ADMIN')")
    @ResponseBody
    public String userAccess() {
        return ">>>	User	Contents!";
    }
    @GetMapping("/api/test/pm")
    @PreAuthorize("hasRole('PM')	or	hasRole('ADMIN')")
    @ResponseBody
    public String projectManagementAccess() {
        return ">>>	Project	Management	Board";
    }
    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String adminAccess() {
        return ">>>	Admin	Contents";
    }

        @GetMapping("/api/test/doctor")
        @PreAuthorize("hasRole('doctor')	or	hasRole('ADMIN')")
        @ResponseBody
        public String doctorAccess() {
            return ">>>	doctor	Contents!";
        }
    @GetMapping("/api/test/patient")
    @PreAuthorize("hasRole('patient')	or	hasRole('ADMIN')")
    @ResponseBody
    public String patientAccess() {
        return ">>> patient	Contents!";
    }

}