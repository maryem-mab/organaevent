package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.login.LoginRequest;
import com.example.OrganaEvent.entity.employe;
import com.example.OrganaEvent.entity.entreprise;
import com.example.OrganaEvent.entity.organisateur;
import com.example.OrganaEvent.repository.EmployeRepository;
import com.example.OrganaEvent.repository.EntrepriseRepository;
import com.example.OrganaEvent.repository.OrganisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        if (organisateurRepository.existsByEmailAndMotDePasse(request.getEmail(), request.getMotDePasse())) {
            return "✅ Organisateur connecté !";
        }

        if (entrepriseRepository.existsByEmailAndMotDePasse(request.getEmail(), request.getMotDePasse())) {
            return "✅ Entreprise connectée !";
        }

        if (employeRepository.existsByEmailAndMotDePasse(request.getEmail(), request.getMotDePasse())) {
            return "✅ Employé connecté !";
        }

        return "❌ Email ou mot de passe incorrect";
    }
}

