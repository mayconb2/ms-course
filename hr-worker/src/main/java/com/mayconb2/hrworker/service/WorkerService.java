package com.mayconb2.hrworker.service;

import com.mayconb2.hrworker.controllers.WorkerController;
import com.mayconb2.hrworker.entities.Worker;
import com.mayconb2.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class WorkerService {

    @Value("${test.config}")
    private String testeConfig;

    @Autowired
    Environment env;

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    private WorkerRepository workerRepository;

    @Autowired
    WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("Port =" + env.getProperty("local.server.port"));
        Worker worker = workerRepository.findById(id).get();
        return ResponseEntity.ok(worker);
    }

    public ResponseEntity<Void> getConfigs(){
        logger.info("CONFIG = " + testeConfig);
        return ResponseEntity.noContent().build();
    }
}
