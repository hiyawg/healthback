package com.HospitalMangagmentSystem.demo.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PaymentDto {
    private double cost;

    private double tax;

    private double discount;

    private double total;

    private String visitdetails;

    private String patientname;


    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date DateOfbirth;

    private String Other_Details;

    private String doctordetails;
    private String name ;

    private String department;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date daydatetime;

    private int daynumber;

    public double getCost() {
        return cost;
    }

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return total;
    }

    public String getVisitdetails() {
        return visitdetails;
    }

    public String getPatientname() {
        return patientname;
    }

    public Date getDateOfbirth() {
        return DateOfbirth;
    }

    public String getOther_Details() {
        return Other_Details;
    }

    public String getDoctordetails() {
        return doctordetails;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDaydatetime() {
        return daydatetime;
    }

    public int getDaynumber() {
        return daynumber;
    }
}
