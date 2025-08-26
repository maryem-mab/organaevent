package com.example.OrganaEvent.services;
import com.example.OrganaEvent.entity.Organisateur;
import com.example.OrganaEvent.repository.OrganisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisateurService {
    @Autowired
    private OrganisateurRepository organisateurRepository;

    public Organisateur register(Organisateur org) {
        return organisateurRepository.save(org);
    }

    public Organisateur login(String email, String motDePasse) {
        Optional<Organisateur> org = organisateurRepository.findByEmailAndMotDePasse(email, motDePasse);
        return org.orElse(null);
    }

    public List<Organisateur> getAll() {
        return organisateurRepository.findAll();
    }
}

