package com.HospitalMangagmentSystem.demo.message.request;
import java.util.Set;
        import javax.validation.constraints.*;
public class SignUpForm {
    private String address;
    private String conformPassword;
    private String department;
    private String designation;
    private String dob;
    private String education;
    private String first;
    private String gender;
    private String last;
    private String mobile;
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

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

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public String getConformPassword() {
        return conformPassword;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDob() {
        return dob;
    }

    public String getEducation() {
        return education;
    }

    public String getFirst() {
        return first;
    }

    public String getGender() {
        return gender;
    }

    public String getLast() {
        return last;
    }

    public String getMobile() {
        return mobile;
    }
}