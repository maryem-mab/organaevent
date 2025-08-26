package com.example.OrganaEvent.services;
import com.example.OrganaEvent.entity.Entreprise;
import com.example.OrganaEvent.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    // Ajouter une entreprise
    public Entreprise register(Entreprise entreprise) {
        // Vérifier si email déjà utilisé
        if (entrepriseRepository.existsByEmail(entreprise.getEmail())) {
            throw new RuntimeException("Email déjà utilisé !");
        }
        return entrepriseRepository.save(entreprise);
    }

    // Récupérer toutes les entreprises
    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    // Récupérer une entreprise par ID
    public Entreprise getById(Long id) {
        return entrepriseRepository.findById(id).orElse(null);
    }
}

