package com.mayconb2.hrpayroll.services;

import com.mayconb2.hrpayroll.entities.Payment;

import com.mayconb2.hrpayroll.entities.Worker;
import com.mayconb2.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    @Autowired
    PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {
        Worker woker = workerFeignClient.findById(workerId).getBody();
        return new Payment(woker.getName(), woker.getDailyIncome(), days);
    }
}
