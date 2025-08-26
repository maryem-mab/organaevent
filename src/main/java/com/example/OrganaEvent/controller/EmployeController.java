package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.entity.Employe;
import com.example.OrganaEvent.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;

    @PostMapping("/add")
    public Employe ajouter(@RequestBody Employe e) {
        return employeRepository.save(e);
    }

    @GetMapping("/all")
    public List<Employe> afficherTout() {
        return employeRepository.findAll();
    }
}
