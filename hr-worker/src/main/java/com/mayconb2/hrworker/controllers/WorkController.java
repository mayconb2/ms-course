package com.mayconb2.hrworker.controllers;

import com.mayconb2.hrworker.entities.Worker;
import com.mayconb2.hrworker.repositories.WorkerRepository;
import com.mayconb2.hrworker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkController {

    private WorkerService workerService;

    @Autowired
    WorkController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return workerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        return workerService.findById(id);
    }
}
