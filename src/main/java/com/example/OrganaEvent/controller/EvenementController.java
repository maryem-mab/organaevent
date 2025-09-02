package com.example.OrganaEvent.controller;


import com.example.OrganaEvent.entity.Evenement;
import com.example.OrganaEvent.services.EvenementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenements")
@CrossOrigin(origins = "http://localhost:4200")
public class EvenementController {

    private final EvenementService service;

    public EvenementController(EvenementService service) {
        this.service = service;
    }

    @PostMapping
    public Evenement create(@RequestBody Evenement e) {
        return service.createEvenement(e);
    }

    @GetMapping
    public List<Evenement> getAll() {
        return service.getAllEvenements();
    }

    @GetMapping("/{id}")
    public Evenement getById(@PathVariable Long id) {
        return service.getEvenementById(id);
    }

    @PutMapping("/{id}")
    public Evenement update(@PathVariable Long id, @RequestBody Evenement e) {
        return service.updateEvenement(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEvenement(id);
    }
}
