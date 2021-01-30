package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.PaymentDto;

import com.HospitalMangagmentSystem.demo.domain.Payment;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getpayments();

    Payment getpayment(int id);

    Payment createpayment(PaymentDto paydto);

    void deletepayment(int id);

    Payment ubdatepatienttreat(PaymentDto paydto , int id);
}


