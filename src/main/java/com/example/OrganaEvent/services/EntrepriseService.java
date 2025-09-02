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
        if (entrepriseRepository.existsByEmail(entreprise.getEmail())) {
            throw new RuntimeException("Email déjà utilisé !");
        }
        return entrepriseRepository.save(entreprise);
    }

    // Afficher toutes les entreprises
    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    // Afficher une entreprise par ID
    public Entreprise getById(Long id) {
        return entrepriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée !"));
    }

    // Modifier entreprise
    public Entreprise updateEntreprise(Long id, Entreprise newEntreprise) {
        return entrepriseRepository.findById(id).map(e -> {
            e.setNomEntreprise(newEntreprise.getNomEntreprise());
            e.setEmail(newEntreprise.getEmail());
            e.setMotDePasse(newEntreprise.getMotDePasse());
            e.setTelephone(newEntreprise.getTelephone());
            e.setDomaineActivite(newEntreprise.getDomaineActivite());
            return entrepriseRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Entreprise non trouvée !"));
    }

    // Supprimer entreprise
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }
}
