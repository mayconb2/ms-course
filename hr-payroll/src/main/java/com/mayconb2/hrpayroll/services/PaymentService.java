package com.mayconb2.hrpayroll.services;

import com.mayconb2.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Maycon", 200.0, days);
    }
}
