package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.entity.Entreprise;
import com.example.OrganaEvent.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
@CrossOrigin(origins = "http://localhost:4200") // Angular app

public class EntrepriseController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @PostMapping("/add")
    public String ajouterEntreprise(@RequestBody Entreprise entreprise) {
        if (entrepriseRepository.existsByEmail(entreprise.getEmail())) {
            return "Email déjà utilisé !";
        }
        entrepriseRepository.save(entreprise);
        return "Entreprise ajoutée avec succès !";
    }

    // Récupérer toutes les entreprises
    @GetMapping("/all")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }
}
