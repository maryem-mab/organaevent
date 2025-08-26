package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.login.LoginRequest;
import com.example.OrganaEvent.repository.EmployeRepository;
import com.example.OrganaEvent.repository.EntrepriseRepository;
import com.example.OrganaEvent.repository.OrganisateurRepository;
import com.example.OrganaEvent.entity.Employe;
import com.example.OrganaEvent.entity.Entreprise;
import com.example.OrganaEvent.entity.Organisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    private OrganisateurRepository organisateurRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @PostMapping("/add")
    public String login(@RequestBody LoginRequest request) {

        // Organisateur
        Optional<Organisateur> org = organisateurRepository
                .findByEmailAndMotDePasse(request.getEmail(), request.getMotDePasse());
        if (org.isPresent()) {
            return "✅ Organisateur connecté !";
        }

        // Entreprise
        Optional<Entreprise> ent = entrepriseRepository
                .findByEmailAndMotDePasse(request.getEmail(), request.getMotDePasse());
        if (ent.isPresent()) {
            return "✅ Entreprise connectée !";
        }

        // Employé
        Optional<Employe> emp = employeRepository
                .findByEmailAndMotDePasse(request.getEmail(), request.getMotDePasse());
        if (emp.isPresent()) {
            return "✅ Employé connecté !";
        }

        return "❌ Email ou mot de passe incorrect";
    }
}
