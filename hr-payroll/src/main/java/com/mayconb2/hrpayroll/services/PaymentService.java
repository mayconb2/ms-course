package com.mayconb2.hrpayroll.services;

import com.mayconb2.hrpayroll.entities.Payment;

import com.mayconb2.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workerId, int days) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker woker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment(woker.getName(), woker.getDailyIncome(), days);
    }
}
