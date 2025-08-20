package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.entity.entreprise;
import com.example.OrganaEvent.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @PostMapping("/add")
    public entreprise ajouterEntreprise(@RequestBody entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @GetMapping("/all")
    public List<entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }
}
