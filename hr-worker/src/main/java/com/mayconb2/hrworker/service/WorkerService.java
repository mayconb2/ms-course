package com.mayconb2.hrworker.service;

import com.mayconb2.hrworker.entities.Worker;
import com.mayconb2.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class WorkerService {

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
        Worker worker = workerRepository.findById(id).get();
        return ResponseEntity.ok(worker);
    }
}
