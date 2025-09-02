package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.entity.Entreprise;
import com.example.OrganaEvent.services.EntrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
@CrossOrigin(origins = "http://localhost:4200") // autoriser Angular
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    // Ajouter entreprise
    @PostMapping("/add")
    public String ajouterEntreprise(@RequestBody Entreprise entreprise) {
        try {
            entrepriseService.register(entreprise);
            return "Entreprise ajoutée avec succès !";
        } catch (RuntimeException e) {
            return e.getMessage(); // "Email déjà utilisé !"
        }
    }

    // Afficher toutes les entreprises
    @GetMapping("/all")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.getAll();
    }

    // Afficher entreprise par ID
    @GetMapping("/{id}")
    public Entreprise getEntrepriseById(@PathVariable Long id) {
        return entrepriseService.getById(id);
    }

    // Modifier entreprise
    @PutMapping("/update/{id}")
    public Entreprise updateEntreprise(@PathVariable Long id, @RequestBody Entreprise entreprise) {
        return entrepriseService.updateEntreprise(id, entreprise);
    }

    // Supprimer entreprise
    @DeleteMapping("/delete/{id}")
    public String deleteEntreprise(@PathVariable Long id) {
        entrepriseService.deleteEntreprise(id);
        return "Entreprise supprimée avec succès !";
    }
}
