package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table(name="payment")
public class Payment {
    @Id
    @Column(name="`payment_id")
    @GeneratedValue
    private int payment_id;

    private double cost;

    private double tax;

    private double discount;

    private double total;

    @ManyToOne(fetch= FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name="doctorvisitid")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DoctorsVisit doctors_visits;



    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DoctorsVisit getDoctorvisit() {
        return doctors_visits;
    }

    public void setDoctorvisit(DoctorsVisit doctorvisit) {
        this.doctors_visits = doctorvisit;
    }
}
