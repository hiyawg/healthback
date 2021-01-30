package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.PaymentDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.Doctor;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Payment;
import com.HospitalMangagmentSystem.demo.repository.paymentRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class PaymentserviceImplementation implements PaymentService{
    @Autowired
    paymentRepository payrep;
    @Override
    public List<Payment> getpayments() {

        return payrep.findAll();
    }

    @Override
    public Payment getpayment(int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );
        return null;
    }

    @Override
    public Payment createpayment(PaymentDto paydto) {
        Payment pp = new Payment();
        pp.setCost(paydto.getCost());
        pp.setTax(paydto.getTax());
        pp.setDiscount(paydto.getDiscount());
        pp.setTotal(paydto.getTotal());

        DoctorsVisit docvisit =new DoctorsVisit();
         docvisit.setVisit_Details(paydto.getVisitdetails());

         pp.setDoctorvisit(docvisit);

        return payrep.save(pp);
    }

    @Override
    public void deletepayment(int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );
         payrep.deleteById(id);
    }

    @Override
    public Payment ubdatepatienttreat(PaymentDto paydto, int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );

        pp.setCost(paydto.getCost());
        pp.setTax(paydto.getTax());
        pp.setDiscount(paydto.getDiscount());
        pp.setTotal(paydto.getTotal());

        DoctorsVisit docvisit =new DoctorsVisit();
        docvisit.setVisit_Details(paydto.getVisitdetails());

        pp.setDoctorvisit(docvisit);

        Doctor dd = new Doctor();
           dd.setName(paydto.getName());
           dd.setDepartment(paydto.getDepartment());
           dd.setDoctor_Details(paydto.getOther_Details());
           docvisit.setDoctor(dd);

        Patients pat = new Patients();
         pat.setDateOfbirth(paydto.getDateOfbirth());
         pat.setPatientname(paydto.getPatientname());

         docvisit.setPatient(pat);

        return payrep.save(pp);
    }
}
