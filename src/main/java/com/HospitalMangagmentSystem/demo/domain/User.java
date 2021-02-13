package com.HospitalMangagmentSystem.demo.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


import java.util.HashSet;
        import java.util.Set;

        import javax.persistence.Entity;
        import javax.persistence.FetchType;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.JoinColumn;
        import javax.persistence.JoinTable;
        import javax.persistence.ManyToMany;
        import javax.persistence.Table;
        import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

    @Entity
    @Table(name = "users", uniqueConstraints = {
            @UniqueConstraint(columnNames = {
                    "username"
            }),
            @UniqueConstraint(columnNames = {
                    "email"
            })
    })
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;



        @NotBlank
        @Size(min = 3, max = 50)
        private String username;

        private String address;
        //private String conformPassword;
        private String department;
        private String designation;
        private String dob;
        private String education;
        @NotBlank
        @Size(min = 6, max = 100)
        private String password;
        private String first;
        private String gender;
        private String last;
        private String mobile;



        @NaturalId(mutable=true)
        @Size(max = 50)
        @Email
        private String email;

        @OneToOne(fetch = FetchType.LAZY,
                cascade =  CascadeType.ALL,
                mappedBy = "user")
        private ImageAttachment image;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        public User() {
        }

        public User( String username, String email,
                    String first,String last,String dob,String mobile,String designation,String address,
                     String education,String gender,String department,String password
                    ) {

            this.username = username;
            this.email = email;
            this.password = password;
            this.first = first;
            this.last = last;
            this.dob = dob;
            this.mobile = mobile;
            this.designation= designation;
            this.address = address;
            this.education = education;
            this.gender = gender;
            this.department = department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }



        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }





        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public ImageAttachment getImage() {
            return image;
        }

        public void setImage(ImageAttachment image) {
            this.image = image;
        }
    }

